package it.unibo.IngSW.common;

import it.unibo.IngSW.common.interfaces.ISensorDisplay;

import javax.swing.JComponent;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.03
 */
public class ThermometerDisplay extends JComponent implements ISensorDisplay {

	public ThermometerDisplay(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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