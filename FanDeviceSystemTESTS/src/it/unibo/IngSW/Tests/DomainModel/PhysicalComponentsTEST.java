package it.unibo.IngSW.Tests.DomainModel;

import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import it.unibo.IngSW.Tests.CLASSES.HybridButton;
import it.unibo.IngSW.Tests.CLASSES.PhysicalLed;
import it.unibo.IngSW.Tests.CLASSES.TruePhysicalButton;
import it.unibo.IngSW.Tests.CLASSES.interfaces.IButton;
import it.unibo.IngSW.Tests.CLASSES.interfaces.ILed;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhysicalComponentsTEST {

	private TruePhysicalButton tbutton = new TruePhysicalButton('o');
	private IButton button = new HybridButton("(Barra Spazziatrice)",tbutton);
	private ILed led = new PhysicalLed();

	private JFrame frame = new JFrame();
	private JPanel contentPane;
	private JTextField text = new JTextField();

	private void scrivi(String s) {
		text.setText(s);
	}

	@Before
	public void beforeAll() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		//contentPane.add((JButton) button, BorderLayout.CENTER);
		frame.addKeyListener(tbutton);
		button=tbutton;
		contentPane.add(text, BorderLayout.NORTH);
		contentPane.add((JLabel) led, BorderLayout.EAST);

		frame.setVisible(true);
		frame.requestFocusInWindow();
	}

	@Test
	public void button() {

		scrivi("Non premere il tasto");
		assertTrue(!button.isPressed());

		boolean pressed = false;
		scrivi("Premere il tasto entro 5 secondi");
		long starttime = System.currentTimeMillis();
		long delta = (System.currentTimeMillis() - starttime);
		while (delta < 5000l) {
			scrivi("Premere il tasto entro " + (5000 - delta) + " millisecondi");
			if (button.isPressed())
				pressed = true;
			delta = (System.currentTimeMillis() - starttime);
		}
		assertTrue(pressed);

		try {
			scrivi("Premere ancora il tasto entro 5 secondi");
			starttime = System.currentTimeMillis();
			Thread.sleep(5000);
			scrivi("Non premere il tasto");
			Thread.sleep(2000);
			assertTrue(button.isPressed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void led() {
		try {
			scrivi("Premere il tasto quando il LED si accende");
			Thread.sleep(2000);
			assertTrue(!button.isPressed());
			led.turnOn();
			Thread.sleep(2000);
			assertTrue(button.isPressed());
			led.turnOff();
		} catch (Exception e) {

		}

	}

	@After
	public void AfterAll() {
		frame.dispose();
	}

}
