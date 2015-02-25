package it.unibo.IngSW.FanDevice.interfaces;
import it.unibo.IngSW.common.Command;
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
	 * @throws Exception 
	 */
	public void connect(int viewersPort, int controlUnitPort) throws Exception;

	public void disconnect();

	public Command receiveCommand() throws Exception;

	/**
	 * 
	 * @param data
	 * @throws Exception 
	 */
	public void sendData(ISensorData[] data) throws Exception;

}