package it.unibo.IngSW.ControlUnit;

import it.unibo.IngSW.common.interfaces.ISensorDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 08-feb-2015 17.14.05
 */
public class LEDDisplay implements ISensorDisplay {

	public LEDDisplay(){

	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return "";
	}

	public boolean isInput(){
		return false;
	}

	/**
	 * 
	 * @param data
	 */
	public void updateView(String data){

	}

}