package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlCmdConsole;
import it.unibo.IngSW.common.FanSpeed;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlCmdConsole implements IControlCmdConsole {

	public ControlCmdConsole(){

	}

	public void finalize() throws Throwable {

	}

	public boolean decSpeed(){
		return false;
	}

	public boolean incSpeed(){
		return false;
	}

	public String readCommand(){
		return "";
	}

	/**
	 * 
	 * @param speed
	 */
	public boolean setSpeed(FanSpeed speed){
		return false;
	}

	public boolean start(){
		return false;
	}

	public boolean stop(){
		return false;
	}

}