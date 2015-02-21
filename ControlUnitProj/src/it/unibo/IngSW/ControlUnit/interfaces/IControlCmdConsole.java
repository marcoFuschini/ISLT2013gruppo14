package it.unibo.IngSW.ControlUnit.interfaces;
import it.unibo.IngSW.common.FanSpeed;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IControlCmdConsole {

	public boolean decSpeed();

	public boolean incSpeed();

	public String readCommand();

	/**
	 * 
	 * @param speed
	 */
	public boolean setSpeed(FanSpeed speed);

	public boolean start();

	public boolean stop();

}