package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;

import javax.swing.JFrame;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.59
 */
public class Display extends JFrame implements IDisplay {

	public IElementDisplay m_IElementDisplay;

	public Display(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param el
	 */
	public void addElementDisplay(IElementDisplay el){

	}

	/**
	 * 
	 * @param sensorName
	 */
	public void removeElementDisplay(String sensorName){

	}

	/**
	 * 
	 * @param data
	 * @param sensorName
	 */
	public void updateSensorData(String data, String sensorName){

	}

}