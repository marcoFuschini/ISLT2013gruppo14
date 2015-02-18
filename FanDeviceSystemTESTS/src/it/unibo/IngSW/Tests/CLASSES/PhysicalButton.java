package it.unibo.IngSW.Tests.CLASSES;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.IngSW.Tests.CLASSES.interfaces.IButton;

public class PhysicalButton extends JButton implements IButton{

	private boolean pressed = false;
	

	public PhysicalButton() {
		super();
		this.setText("TEST");
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pressed=true;
				
			}
		});
		
	}

	@Override
	public boolean isPressed() {
		boolean ret = pressed;
		pressed = false;
		return ret;
	}
	
	


}
