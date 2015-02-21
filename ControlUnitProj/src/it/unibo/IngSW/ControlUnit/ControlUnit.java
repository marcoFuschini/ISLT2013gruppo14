package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.common.interfaces.IComunication;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 08-feb-2015 17.14.02
 */
public class ControlUnit implements IControlUnit {

	public ControlUnit(IDisplay disp, IControlCmdConsole console, IComunication client){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param elementDisplay
	 */
	public void addElementDisplay(IElementDisplay elementDisplay){

	}

	public boolean isAlive(){
		return false;
	}

	public ISensorData[] receiveData(){
		return null;
	}

	public String receiveInput(){
		return "";
	}

	/**
	 * 
	 * @param displayName
	 */
	public void removeElementDisplay(String displayName){

	}

	/**
	 * 
	 * @param cmd
	 */
	public void sendCommand(String cmd){

	}

	/**
	 * 
	 * @param data
	 */
	public void showSensorData(ISensorData[] data){

	}

	/**
	 * 
	 * @param state
	 */
	public void showState(ISensorData state){

	}

	public void turnOff(){

	}


}