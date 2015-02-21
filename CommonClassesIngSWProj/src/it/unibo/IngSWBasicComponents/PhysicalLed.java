package it.unibo.IngSWBasicComponents;

import it.unibo.IngSW.common.interfaces.ILed;

import java.awt.Color;

import javax.swing.JLabel;

public class PhysicalLed extends JLabel implements ILed {

	//private Toolkit tool= Toolkit.getDefaultToolkit();
	
	public PhysicalLed() {
		super("LED");
		setOpaque(true);
		setForeground(Color.BLACK);
		turnOff();
	}
	
	@Override
	public void turnOff() {
		setBackground(Color.GRAY);
		//tool.setLockingKeyState(KeyEvent.VK_NUM_LOCK,Boolean.FALSE);
	}

	@Override
	public void turnOn() {
		setBackground(Color.RED);
		//tool.setLockingKeyState(KeyEvent.VK_NUM_LOCK,Boolean.FALSE);
	}

}
