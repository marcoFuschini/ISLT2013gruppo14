package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSWBasicComponents.Communicator;

import java.util.ArrayList;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceCommunicator implements IFanDeviceCommunicator {
	
	protected ICommunicator comm;
	protected int cuID;
	protected ArrayList<Integer> viewers;
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
	 */
	public void connect(int viewersPort, int controlUnitPort){
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(run){
					viewers.add(comm.connect("server", viewersPort));
				}
			}
			
		});
		cuID=comm.connect("server", controlUnitPort);
	}

	public void disconnect(){
		comm.disconnect(cuID);
		for (Integer i : viewers){
			comm.disconnect(i);
		};
	}

	public String receiveCommand(){
		String command=comm.read(cuID);
		return command;
	}

	/**
	 * 
	 * @param data
	 */
	public void sendData(ISensorData[] data){
		//TODO
		
	}

}