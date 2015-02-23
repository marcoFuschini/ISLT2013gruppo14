package it.unibo.IngSW.Viewer.interfaces;
import it.unibo.IngSW.common.interfaces.ICommunicator;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IViewerCommunicator {

//	public ICommunicator m_ICommunicator;

	/**
	 * 
	 * @param fanDeviceIP
	 * @param fanDevicePort
	 * @throws Exception 
	 */
	public void connect(String fanDeviceIP, int fanDevicePort) throws Exception;

	public void disconnect() throws Exception;

	public ISensorData[] receiveData() throws Exception;

}