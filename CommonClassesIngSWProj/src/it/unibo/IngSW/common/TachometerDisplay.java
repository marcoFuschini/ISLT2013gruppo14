package it.unibo.IngSW.common;
import javax.swing.JLabel;

import it.unibo.IngSW.common.interfaces.IElementDisplay;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class TachometerDisplay extends JLabel implements IElementDisplay {

	private double value=0;
	
	public TachometerDisplay(){
		refresh();
	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return SensorName.SPEED.toString();
	}

	public void refresh(){
		this.setText("Speed: "+value);
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		this.value=Double.parseDouble(value);
	}

}