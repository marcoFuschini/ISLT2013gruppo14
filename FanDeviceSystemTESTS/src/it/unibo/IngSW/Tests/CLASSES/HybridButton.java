package it.unibo.IngSW.Tests.CLASSES;



import it.unibo.IngSW.Tests.CLASSES.interfaces.IButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class HybridButton extends JButton implements IButton{

	private TruePhysicalButton trueButton;

	public HybridButton(String s,TruePhysicalButton truebutton) {
		super(s);
		this.setText(s);
		this.trueButton=truebutton;
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				truebutton.keyReleased(new KeyEvent(null, 0, System.currentTimeMillis(), 0, 
						Character.getNumericValue(truebutton.getKeyBinded()), truebutton.getKeyBinded()));
			}

		});
		this.addKeyListener(truebutton);
		
	}

	@Override
	public boolean isPressed() {
		return trueButton.isPressed();
	}
	
	


}
