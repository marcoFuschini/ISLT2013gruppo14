package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceCommunicator implements IFanDeviceCommunicator {
	
	protected ICommunicator comm;
	protected int cuID;
	protected List<Integer> viewers;
	protected boolean run;
	protected int vPort;
	protected int cuPort;
	
	public FanDeviceCommunicator(){
		comm=new Communicator();
		viewers=new ArrayList<Integer>();
		run=true;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param viewersPort
	 * @param controlUnitPort
	 * @throws Exception 
	 */
	public void connect(int viewersPort, int controlUnitPort) throws Exception{
		cuID=comm.connect("server", controlUnitPort);
		cuPort=controlUnitPort;
		vPort=viewersPort;
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(run){
					try {
						int vid=comm.connect("server", viewersPort);
						viewers.add(vid);
						//run=false;
						System.out.println("viewer "+vid+" connected");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void disconnect(){
		run=false;
		try {
			comm.disconnect(cuID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Integer i : viewers){
			try {
				comm.disconnect(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			comm.closeServer(vPort);
			comm.closeServer(cuPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Command receiveCommand() throws Exception{
		String msg=comm.read(cuID);
		if(msg==null){
			throw new Exception("ControlUnit disconnected");
		}
		Command command=JSONConverter.JSONToCommand(msg);
		return command;
	}

	/**
	 * 
	 * @param data
	 * @throws Exception 
	 */
	public void sendData(ISensorData[] data) throws Exception{
		String msg=JSONConverter.SensorDataToJSON(data);
		comm.write(cuID, msg);
		for(int i=0;i<viewers.size();i++){
			System.out.println("viewer "+(i+1)+" of "+viewers.size());
			try{
				comm.write(viewers.get(i),msg);
				String s=comm.read(viewers.get(i));
				if(!s.equals("ack")){
					viewers.remove(i);
					i--;
				}
			}catch(Exception e){
				viewers.remove(i);
				i--;
				e.printStackTrace();
			}
		}
	}

}