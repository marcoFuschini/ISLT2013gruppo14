package it.unibo.IngSW.Simulatori;

import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.IFanDevice;

public class SimFanDevice implements IFanDevice {

	private FanSpeed speed;
	
	public SimFanDevice() {
		speed=FanSpeed.ZEROSPEED;
	}
	
	@Override
	public void setSpeed(FanSpeed speed) {
		this.speed=speed;
	}
	
	public FanSpeed getSpeed(){
		return speed;
	}

}
