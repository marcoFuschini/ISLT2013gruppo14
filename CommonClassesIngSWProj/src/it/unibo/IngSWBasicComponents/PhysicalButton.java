package it.unibo.IngSWBasicComponents;

import it.unibo.IngSW.common.interfaces.IButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PhysicalButton implements IButton, KeyListener {

	private boolean pressed=false;
	private char keyToListen;
	
	public PhysicalButton(char keyToListen) {
		super();
		this.keyToListen=keyToListen;
	}
	
	public char getKeyBinded(){
		return keyToListen;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		return;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar()==keyToListen){
			pressed=true;
		}
	}

	@Override
	public boolean isPressed() {
		boolean ret = pressed;
		pressed = false;
		return ret;
	}

}
