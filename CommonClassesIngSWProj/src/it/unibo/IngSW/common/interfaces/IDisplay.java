package it.unibo.IngSW.common.interfaces;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface IDisplay {

	public IElementDisplay m_IElementDisplay;

	/**
	 * 
	 * @param el
	 */
	public void addSensorDisplay(IElementDisplay el);

	/**
	 * 
	 * @param sensorName
	 */
	public void removeSensorDisplay(String sensorName);

	/**
	 * 
	 * @param data
	 * @param sensorName
	 */
	public void updateSensorData(String data, String sensorName);

}