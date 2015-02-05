package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.IFanDevice;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.common.interfaces.IComunication;
import it.unibo.IngSW.common.interfaces.ISensorData;


/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public class FanDevice implements IFanDevice {

	protected IComunication serverComunicator;
	protected ISensor[] sensors;

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

	public ISensorData[] receiveSensorData(){
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
	public void sendData(ISensorData[] dataToSend){

	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed){

	}

	public void start(){

	}

	public void stop(){

	}

}