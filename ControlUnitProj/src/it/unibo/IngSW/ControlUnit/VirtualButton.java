package it.unibo.IngSW.ControlUnit;
import it.unibo.IngSW.common.interfaces.IButton;

import javax.swing.JButton;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.35
 */
public class VirtualButton extends JButton implements IButton {

	public VirtualButton(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public boolean isPressed(){
		return false;
	}

}