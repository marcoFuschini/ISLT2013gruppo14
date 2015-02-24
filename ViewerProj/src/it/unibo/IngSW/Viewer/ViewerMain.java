package it.unibo.IngSW.Viewer;

import it.unibo.IngSW.Viewer.interfaces.IViewer;
import it.unibo.IngSW.Viewer.interfaces.IViewerCommunicator;
import it.unibo.IngSW.common.Display;
import it.unibo.IngSW.common.TachometerDisplay;
import it.unibo.IngSW.common.ThermometerDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSWBasicComponents.PhysicalButton;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class ViewerMain {

	private static final int MAXCOLS = 5;

	private static IViewer viewer;
	private static IViewerCommunicator communicator;
	private static JPanel mainPane;
	private static Display display;
	private static IElementDisplay[] displayEls = {new TachometerDisplay(),new ThermometerDisplay()};

	private static void creaGUI() {
		// IMPLEMENTAZIONE SPECIFICA

		mainPane = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		c = new GridBagConstraints();
		c.weightx = 10;
		c.weighty = 10;
		c.gridx = 0;		
		c.gridy = 0;
		c.ipadx = 50;
		c.ipady = 10;

		boolean stop = false;
		int y=0;
		while (!stop) {
			for (int x = 0; x < MAXCOLS; x++) {
				if(displayEls.length<=(x+y*MAXCOLS)){
					stop=true;
					break;
				}
				c.gridx=x;
				c.gridy=y;
				mainPane.add((Component) displayEls[(x+y*MAXCOLS)],c);
			}
			y++;
		}

		display.setContentPane(mainPane);
		display.setResizable(false);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.pack();
		display.setVisible(true);
	}
	
	public static void main(String[] args) {
		communicator = new ViewerCommunicator();
		display=new Display(displayEls);
		viewer = new Viewer(communicator,display);
		creaGUI();
		
		viewer.connect(Integer.parseInt(args[1]), args[0]);
		ISensorData[] data;
		while(display.isVisible()){
			data=viewer.receiveData();
			viewer.updateData(data);
		}
			viewer.diconnect();
	}


}