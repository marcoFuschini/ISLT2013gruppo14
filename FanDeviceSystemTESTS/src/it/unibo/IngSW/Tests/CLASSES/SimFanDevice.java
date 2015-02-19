package it.unibo.IngSW.Tests.CLASSES;

import it.unibo.IngSW.Tests.CLASSES.interfaces.IFanDevice;
import it.unibo.IngSW.Tests.CLASSES.interfaces.ITachometer;

public class SimFanDevice implements IFanDevice {

	private FanSpeed speed;
	
	public SimFanDevice() {
		
	}
	
	@Override
	public void setSpeed(FanSpeed speed) {
		this.speed=speed;
	}
	
	public FanSpeed getSpeed(){
		return speed;
	}

}
