package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceCommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceCommunicator implements IFanDeviceCommunicator {

	public FanDeviceCommunicator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param viewersPort
	 * @param controlUnitPort
	 */
	public void connect(int viewersPort, int controlUnitPort){

	}

	public void disconnect(){

	}

	public String receiveCommand(){
		return "";
	}

	/**
	 * 
	 * @param data
	 */
	public void sendData(ISensorData[] data){

	}

}