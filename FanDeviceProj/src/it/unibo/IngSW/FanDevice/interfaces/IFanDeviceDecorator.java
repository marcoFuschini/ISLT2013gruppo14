package it.unibo.IngSW.FanDevice.interfaces;
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
	 */
	public void connect(int viewerPort, int controlUnitPort);

	public void decSpeed();

	public ISensorData[] getSensorData();

	public void incSpeed();

	public String receiveCommand();

	/**
	 * 
	 * @param data
	 */
	public void sendData(ISensorData[] data);

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(FanSpeed speed);

}