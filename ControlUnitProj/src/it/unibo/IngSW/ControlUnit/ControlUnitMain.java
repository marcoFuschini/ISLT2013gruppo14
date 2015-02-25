package it.unibo.IngSW.ControlUnit;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnitCommunicator;
import it.unibo.IngSW.common.Display;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.TachometerDisplay;
import it.unibo.IngSW.common.ThermometerDisplay;
import it.unibo.IngSW.common.interfaces.IButton;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.HybridButton;
import it.unibo.IngSWBasicComponents.PhysicalButton;
import it.unibo.IngSWBasicComponents.VirtualButton;
import it.unibo.IngSWBasicComponents.VirtualLed;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class ControlUnitMain {

	private static IControlUnit controlUnit;
	private static Display display;
	private static PhysicalButton[] pButtons = { new PhysicalButton(' ') };
	private static IButton[] buttons = { new VirtualButton("Start"),
			new HybridButton("Stop", pButtons[0]), new VirtualButton("LOW"),
			new VirtualButton("MID"), new VirtualButton("HIGH"),
			new VirtualButton("decrement speed"), 
			new VirtualButton("increment speed")};
	private static IElementDisplay[] displayEls = { new VirtualLed(),
			new TachometerDisplay(), new ThermometerDisplay() };

	private static JPanel mainPane;
	private static boolean inputSenderRun = true,datReceiverRun=true;

	/**
	 * 
	 * @param args
	 */
	private static void creaGUI() {
		// IMPLEMENTAZIONE SPECIFICA

		// registro i bottoni fisici in modo da ascoltare le pressioni dei tasti
		// sul frame
		for (PhysicalButton pb : pButtons) {
			display.addKeyListener(pb);
		}

		// inserisco i componenti grafici nel panel
		mainPane = new JPanel(new GridBagLayout());
		GridBagConstraints c;
		c = new GridBagConstraints();
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		mainPane.add((Component) displayEls[0], c);// led
		c.gridx++;
		mainPane.add((JButton) buttons[0], c);// start
		c.gridx++;
		mainPane.add((JButton) buttons[1], c);// stop
		c.gridx = 0;
		c.gridy++;
		mainPane.add((JButton) buttons[2], c);// low
		c.gridx++;
		mainPane.add((JButton) buttons[3], c);// mid
		c.gridx++;
		mainPane.add((JButton) buttons[4], c);// high
		c.gridx = 0;
		c.gridy++;
		mainPane.add((JButton) buttons[5], c);// dec
		c.gridx++;
		mainPane.add((JButton) buttons[6], c);// inc
		c.gridx = 0;
		c.gridy++;
		c.gridy++;

		mainPane.add((Component) displayEls[1], c);// Speed
		c.gridx++;
		mainPane.add((Component) displayEls[2], c);// Temperature
		c.gridx++;

		display.setContentPane(mainPane);
		display.setResizable(false);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.pack();
		display.setVisible(true);

	}

	public static void main(String[] args) {
		// init
		display = new Display(displayEls);
		controlUnit = new ControlUnit(display, buttons);
		try {
			controlUnit.connect(args[0],Integer.parseInt(args[1]));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			return;
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
		creaGUI();
		Thread inputSenderT = new Thread(new Runnable() {

			@Override
			public void run() {
				String cmd;
				String json;
				do {

					try {
						cmd = controlUnit.readCommand();
						scrivi("ricevuto comando: "+cmd);
//						json = JSONConverter.commandToJSON(cmd);
						json=cmd;
						controlUnit.sendCommand(json);
						scrivi("comando inviato");
					} catch (Exception e) {
						scrivi("eccezione catchata, muoio");
						kill();
						e.printStackTrace();
					}
				} while (inputSenderRun);
			}
		});
		
		inputSenderT.start();
		
		ISensorData[] data;
		do{
			try{
			data=controlUnit.receiveData();
			scrivi("dati ricevuti ");
			controlUnit.updateData(data);
			scrivi("dati scritti");
			}catch (Exception e){
				scrivi("eccezione catchata, muoio");
				kill();
				e.printStackTrace();
			}
		}while(datReceiverRun&&display.isVisible());
		kill();
	}
	
	protected static void scrivi(String string) {
//		System.out.println(string);
	}

	private static void kill(){
		inputSenderRun=false;
		datReceiverRun=false;
		try {
			controlUnit.disconnect();
		} catch (Exception e) {
		}
		display.dispose();
	}

}