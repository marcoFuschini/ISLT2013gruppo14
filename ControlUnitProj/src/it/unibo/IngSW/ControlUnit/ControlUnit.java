package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.interfaces.IButton;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnit implements IControlUnit {

	//CONSTANTS
	public static final int CMDBUFFERMAXSIZE=20;
	
	
	private IControlUnitCommunicator communicator;
	private IDisplay display;
	private IButton[] buttons;
	
	private InputPoller inputpoller;
	private IControlCmdConsole controlcmdconsole;
	
	public ControlUnit(IControlUnitCommunicator communicator,IDisplay display, IButton[] buttons){
		this.communicator=communicator;
		this.display=display;
		this.buttons=buttons;
		this.controlcmdconsole=new ControlCmdConsole();
		this.inputpoller=new InputPoller(controlcmdconsole,buttons);
	}

	public void connect(String fanDeviceIP, int fanDevicePort){
		communicator.connect(fanDeviceIP, fanDevicePort);
	}

	public void disconnect(){
		communicator.disconnect();
	}

	public String readCommand(){
		return controlcmdconsole.readCommand();
	}

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command){
		communicator.sendCommand(command);
	}

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data){
		for(ISensorData d:data){
			display.writeData(d.getValue(), d.getName());
		}
	}

	@Override
	public ISensorData[] receiveData() {
		return communicator.receiveData();
	}

}