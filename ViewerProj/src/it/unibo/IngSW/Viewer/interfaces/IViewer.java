package it.unibo.IngSW.Viewer.interfaces;

import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.common.interfaces.ISensorDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface IViewer {

	public IDisplay m_IDisplay=null;

	public ISensorData[] receiveData();

	/**
	 * 
	 * @param data
	 */
	public void showSensorData(ISensorData[] data);

	/**
	 * 
	 * @param stateData
	 */
	public void showState(ISensorData stateData);
	
	public void addSensorDisplay(ISensorDisplay elementDisplay);
	public void removeSensorDisplay(ISensorDisplay elementDisplay);
	
}