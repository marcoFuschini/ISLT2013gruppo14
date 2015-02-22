package it.unibo.IngSW.common;
import javax.swing.JLabel;

import it.unibo.IngSW.common.interfaces.IElementDisplay;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class ThermometerDisplay extends JLabel implements IElementDisplay {

	private double value;
	
	public ThermometerDisplay(){

	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return "thermometer";
	}

	public void refresh(){
		this.setText(value+"�C");
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		this.value=Double.parseDouble(value);
	}

}