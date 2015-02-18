package it.unibo.IngSW.Tests.CLASSES;

import java.awt.Color;

import javax.swing.JLabel;

import it.unibo.IngSW.Tests.CLASSES.interfaces.ILed;

public class PhysicalLed extends JLabel implements ILed {

	
	public PhysicalLed() {
		super("LED");
		setOpaque(true);
		setForeground(Color.BLACK);
		turnOff();
	}
	
	@Override
	public void turnOff() {
		setBackground(Color.GRAY);
	}

	@Override
	public void turnOn() {
		setBackground(Color.RED);
	}

}
