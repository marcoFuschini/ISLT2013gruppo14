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
		try {
			communicator.connect(fanDeviceIP, fanDevicePort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect(){
		try {
			communicator.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readCommand(){
		return controlcmdconsole.readCommand();
	}

	/**
	 * 
	 * @param command
	 */
	public void sendCommand(String command){
		try {
			communicator.sendCommand(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			return communicator.receiveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}