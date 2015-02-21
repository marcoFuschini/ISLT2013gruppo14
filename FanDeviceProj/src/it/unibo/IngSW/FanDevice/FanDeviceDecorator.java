package it.unibo.IngSW.FanDevice;
import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceDecorator;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceDecorator implements IFanDeviceDecorator {

	public FanDeviceDecorator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param viewerPort
	 * @param controlUnitPort
	 */
	public void connect(int viewerPort, int controlUnitPort){

	}

	public void decSpeed(){

	}

	public ISensorData[] getSensorData(){
		return null;
	}

	public void incSpeed(){

	}

	public String receiveCommand(){
		return "";
	}

	/**
	 * 
	 * @param data
	 */
	public void sendData(ISensorData[] data){

	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed){

	}

}