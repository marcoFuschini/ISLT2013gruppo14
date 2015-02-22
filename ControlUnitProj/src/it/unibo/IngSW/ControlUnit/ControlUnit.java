package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnit implements IControlUnit {

	
	private IControlUnitCommunicator communicator;
	private IDisplay display;
	
	private InputPoller inputpoller;
	private IControlCmdConsole controlcmdconsole;
	
	public ControlUnit(IControlUnitCommunicator communicator,IDisplay display){
		this.communicator=communicator;
		this.display=display;
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

	public String readCommand(){
		return "";
	}

	/**
	 * 
	 * @param data
	 */
	public void receiveData(ISensorData[] data){

	}

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command){

	}

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data){

	}

}