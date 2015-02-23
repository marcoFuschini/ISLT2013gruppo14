package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnitCommunicator implements IControlUnitCommunicator {
	
	protected ICommunicator comm;
	protected int fdID;
	
	public ControlUnitCommunicator(){
		comm=new Communicator();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 */
	public void connect(String fanDeviceIP, int fanDevicePort){
		fdID=comm.connect(fanDeviceIP, fanDevicePort);
	}

	public void disconnect(){
		comm.disconnect(fdID);
	}

	public ISensorData[] receiveData(){
		String msg=comm.read(fdID);
		ISensorData[] data = JSONConverter.JSONToSensorData(msg);
		return data;
	}

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command){
		String msg=JSONConverter.commandToJSON(command);
		comm.write(fdID, command);
	}

}