package it.unibo.IngSW.common.interfaces;

import it.unibo.IngSW.common.FanSpeed;

/**
 * @author Fabio
 * @version 1.0
 * @created 17-feb-2015 18.00.01
 */
public interface IFanDevice {

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed);

}