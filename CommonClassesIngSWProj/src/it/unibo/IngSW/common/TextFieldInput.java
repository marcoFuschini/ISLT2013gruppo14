package it.unibo.IngSW.common;

import it.unibo.IngSW.common.interfaces.IInputDisplay;

import javax.swing.JComponent;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.03
 */
public class TextFieldInput extends JComponent implements IInputDisplay {

	public TextFieldInput(){

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