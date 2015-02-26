package it.unibo.IngSW.common;
import javax.swing.JLabel;

import it.unibo.IngSW.common.interfaces.IElementDisplay;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class StateDisplay extends JLabel implements IElementDisplay {

	private boolean state=false;
	
	public StateDisplay(){
		state=false;
		refresh();
	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return SensorName.STATE.toString();
	}

	public void refresh(){
		if(state){
			this.setText("State: ON ");
		}else{
			this.setText("State: OFF");
		}
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		if(Double.parseDouble(value)==0.0){
			state=false;
		}else{
			state=true;
		};
	}

}