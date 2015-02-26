package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.IElementDisplay;

import java.text.DecimalFormat;

import javax.swing.JLabel;

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
		this.setText("Speed: "+new DecimalFormat("#.##").format(value));
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		this.value=Double.parseDouble(value);
	}

}