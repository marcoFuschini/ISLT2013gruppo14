package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

import java.util.Iterator;
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
	
	public FanDeviceCommunicator(){
		comm=new Communicator();
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
		try {
			new Thread(new Runnable(){

				@Override
				public void run() {
					while(run){
						try {
							int vid=comm.connect("server", viewersPort);
							viewers.add(vid);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuID=comm.connect("server", controlUnitPort);
	}

	public void disconnect(){
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
	}

	public String receiveCommand() throws Exception{
		String msg=comm.read(cuID);
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
		for(Integer i:viewers){
			comm.write(i,msg);
		}
	}

}