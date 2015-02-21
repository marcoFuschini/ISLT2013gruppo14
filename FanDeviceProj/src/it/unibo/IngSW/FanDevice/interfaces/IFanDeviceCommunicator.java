package it.unibo.IngSW.FanDevice.interfaces;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IFanDeviceCommunicator {

//	public ICommunicator m_ICommunicator;

	/**
	 * 
	 * @param viewersPort
	 * @param controlUnitPort
	 */
	public void connect(int viewersPort, int controlUnitPort);

	public void disconnect();

	public String receiveCommand();

	/**
	 * 
	 * @param data
	 */
	public void sendData(ISensorData[] data);

}