package it.unibo.IngSW.FanDevice.interfaces;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.IFanDevice;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IFanDeviceDecorator {
/*
	public IFanDevice m_IFanDevice;
	public ISensor m_ISensor;
	public ISensorDataBuffer m_ISensorDataBuffer;
	public IFanDeviceCommunicator m_IFanDeviceCommunicator;
*/
	/**
	 * 
	 * @param viewerPort
	 * @param controlUnitPort
	 * @throws Exception 
	 */
	public void connect(int viewerPort, int controlUnitPort) throws Exception;

	public void decSpeed();

	public ISensorData[] getSensorData() throws InterruptedException;

	public void incSpeed();
	
	public void start();
	
	public void stop();
	
	public void disconnect() throws Exception;
	
	public String receiveCommand() throws Exception;

	/**
	 * 
	 * @param data
	 * @throws Exception 
	 */
	public void sendData(ISensorData[] data) throws Exception;

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed);

}