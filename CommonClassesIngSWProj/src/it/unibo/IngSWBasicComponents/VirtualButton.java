package it.unibo.IngSWBasicComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import it.unibo.IngSW.common.interfaces.IButton;

import javax.swing.JButton;

public class VirtualButton extends JButton implements IButton {

	private boolean pressed = false;

	public VirtualButton(String s) {
		super(s);
		this.setText(s);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized (this) {
					System.out.println(s + " premuto");
					pressed = true;

				}
			}

		});

	}

	@Override
	public boolean isPressed() {
		synchronized (this) {
			boolean ret = pressed;
			pressed = false;
			return ret;

		}
	}

}
