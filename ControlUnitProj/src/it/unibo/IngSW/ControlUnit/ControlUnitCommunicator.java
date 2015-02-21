package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnitCommunicator implements IControlUnitCommunicator {

	public ControlUnitCommunicator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort){

	}

	public void disconnect(){

	}

	public ISensorData[] receiveData(){
		return null;
	}

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command){

	}

}