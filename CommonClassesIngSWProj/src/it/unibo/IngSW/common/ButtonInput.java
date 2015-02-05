package it.unibo.IngSW.common;

import javax.swing.JComponent;

import it.unibo.IngSW.common.interfaces.IInputDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.02.58
 */
public class ButtonInput extends JComponent implements IInputDisplay {

	public ButtonInput(){

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

}