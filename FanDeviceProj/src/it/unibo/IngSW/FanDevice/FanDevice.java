package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.IFanDevice;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.IComunication;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public class FanDevice implements IFanDevice {

	public IComunication m_IComunication;
	public ISensor m_ISensor;

	public FanDevice(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param newSensor
	 */
	public void addSensor(ISensor newSensor){

	}

	public void decSpeed(){

	}

	public void incSpeed(){

	}

	public String receiveCommand(){
		return "";
	}

	public SensorData[] receiveSensorData(){
		return null;
	}

	/**
	 * 
	 * @param sensor
	 */
	public void removeSensor(ISensor sensor){

	}

	/**
	 * 
	 * @param dataToSend
	 */
	public void sendData(SensorData[] dataToSend){

	}

	/**
	 * 
	 * @param speed
	 */

	public void start(){

	}

	public void stop(){

	}

	@Override
	public void setSpeed(FanSpeed speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendData(ISensorData[] dataToSend) {
		// TODO Auto-generated method stub
		
	}

}