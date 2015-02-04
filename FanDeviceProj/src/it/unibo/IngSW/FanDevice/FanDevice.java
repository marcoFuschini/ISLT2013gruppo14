package it.unibo.IngSW.FanDevice;


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
		int a=1;
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
	public void setSpeed(FanSpeed speed){

	}

	public void start(){

	}

	public void stop(){

	}

}