package it.unibo.IngSWBasicComponents;

import it.unibo.IngSW.common.SensorsNames;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ILed;

import java.awt.Color;

import javax.swing.JLabel;

public class VirtualLed extends JLabel implements ILed,IElementDisplay {

	//private Toolkit tool= Toolkit.getDefaultToolkit();
	boolean on=false;
	
	public VirtualLed() {
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

	@Override
	public void refresh() {
		if(on){
			turnOn();
		}else{
			turnOff();
		}
	}

	@Override
	public void setValue(String value) {
		if(Double.parseDouble(value)==0){
			on=false;
		}else{
			on=true;
		}
	}

	@Override
	public String getName(){
		return SensorsNames.STATE.toString();
	}
}
