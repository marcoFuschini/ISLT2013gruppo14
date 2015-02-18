package it.unibo.IngSW.Tests.CLASSES;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import it.unibo.IngSW.Tests.CLASSES.interfaces.ILed;

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
