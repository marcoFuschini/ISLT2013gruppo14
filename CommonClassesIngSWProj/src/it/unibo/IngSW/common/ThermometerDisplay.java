package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.IElementDisplay;

import java.text.DecimalFormat;

import javax.swing.JLabel;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class ThermometerDisplay extends JLabel implements IElementDisplay {

	private double value=0;
	
	public ThermometerDisplay(){
		refresh();
	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return SensorName.TEMPERATURE.toString();
	}

	public void refresh(){
		this.setText(new DecimalFormat("#.##").format(value)+"°C");
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		this.value=Double.parseDouble(value);
	}

}