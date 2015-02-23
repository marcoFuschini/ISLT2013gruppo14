package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.IFanDevice;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDevice implements IFanDevice {
	private FanSpeed speed;
	public FanDevice(){
		speed=FanSpeed.ZEROSPEED;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed){
		this.speed=speed;
	}

}