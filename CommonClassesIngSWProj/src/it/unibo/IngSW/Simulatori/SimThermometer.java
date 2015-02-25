package it.unibo.IngSW.Simulatori;

import it.unibo.IngSW.common.interfaces.IThermometer;

public class SimThermometer implements IThermometer {

	private final double percLOW=0.8;
	private final double percMID=0.4;
	private final double percHIGH=-0.1;
	
	private SimFanDevice fandev;
	private double temp=0;
	private double increment=0;
	
	public SimThermometer(SimFanDevice fandev,double startTemp,double increment) {
		this.fandev=fandev;
		temp=startTemp;
		this.increment=increment;
	}
	@Override
	public double getValue() {
		switch(fandev.getSpeed()){
		case LOWSPEED:
			temp+=percLOW*increment;
			break;
		case MEDIUMSPEED:
			temp+=percMID*increment;
			break;
		case HIGHSPEED:
			temp+=percHIGH*increment;
			break;			
		}
		return temp+=increment;
	}

}
