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
					try {
						while(run){
							int vid=comm.connect("server", viewersPort);
							viewers.add(vid);
							System.out.println("viewer "+vid+" connected");
						}
					} catch (Exception e) {
//						e.printStackTrace();
					}
					scrivi("thread connect viewers terminated");
			}
		}).start();
	}

	public void disconnect(){
		run=false;
		try {
			comm.disconnect(cuID);
			scrivi("cuDisconnected");
		} catch (Exception e) {
//			e.printStackTrace();
		}
		for (Integer i : viewers){
			try {
				comm.disconnect(i);
				scrivi("v disconnected");
			} catch (Exception e) {
				scrivi("v disconnected with exception");
//				e.printStackTrace();
			}
		}
		try {
			comm.closeServer(vPort);
			scrivi("vport closed");
		} catch (Exception e) {
//			e.printStackTrace();
			scrivi("vport closed with exception");
		}
		try{
			comm.closeServer(cuPort);
			scrivi("cuport closed");
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	public String receiveCommand() throws Exception{
		String msg=comm.read(cuID);
		if(msg==null){
			throw new Exception("ControlUnit disconnected");
		}
		String command=JSONConverter.JSONToCommand(msg);
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
//			System.out.println("viewer "+(i+1)+" of "+viewers.size());
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
				System.out.println("Viewer disconnected");
				//e.printStackTrace();
			}
		}
	}
	
	private void scrivi(String s){
//		System.out.println(s);
	}

}