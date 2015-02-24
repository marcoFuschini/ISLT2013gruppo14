package it.unibo.IngSW.Viewer.interfaces;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface IViewer {
/*
	public IDisplay m_IDisplay;
	public IViewerCommunicator m_IViewerCommunicator;
*/
	/**
	 * 
	 * @param fanDevicePort
	 * @param fanDeviceIP
	 * @throws Exception 
	 */
	public void connect(String fanDeviceIP,int fanDevicePort) throws Exception;

	public void diconnect() throws Exception;

	public ISensorData[] receiveData() throws Exception;

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data);

}