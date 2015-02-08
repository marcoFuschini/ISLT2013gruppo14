package it.unibo.IngSW.FanDevice.interfaces;
import it.unibo.IngSW.FanDevice.FanSpeed;

/**
 * @author Fabio
 * @version 1.0
 * @created 05-feb-2015 16.06.26
 */
public interface IActuator {

	public void decSpeed();

	public void incSpeed();

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed);

}