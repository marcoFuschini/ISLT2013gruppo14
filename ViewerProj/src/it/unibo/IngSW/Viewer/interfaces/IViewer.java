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
	 */
	public void connect(int fanDevicePort, String fanDeviceIP);

	public void diconnect();

	public ISensorData[] receiveData();

	/**
	 * 
	 * @param data
	 */
	public void updateData(ISensorData[] data);

}