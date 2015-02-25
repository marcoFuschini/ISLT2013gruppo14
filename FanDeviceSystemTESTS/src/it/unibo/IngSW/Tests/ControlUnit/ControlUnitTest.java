package it.unibo.IngSW.Tests.ControlUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.unibo.IngSW.ControlUnit.ControlUnit;
import it.unibo.IngSW.ControlUnit.interfaces.IControlUnit;
import it.unibo.IngSW.Viewer.Viewer;
import it.unibo.IngSW.common.Display;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.IButton;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControlUnitTest {

	private static final int SERVERPORT = 10001;
	private String el1value = "";
	private String el2value = "";
	private Boolean[] testbtns = { false, false, false, false, false, false,
			false };

	private IButton[] buttons = new IButton[] { new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[0];
			testbtns[0] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[1];
			testbtns[1] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[2];
			testbtns[2] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[3];
			testbtns[3] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[4];
			testbtns[4] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[5];
			testbtns[5] = false;
			return ret;
		}
	}, new IButton() {
		@Override
		public boolean isPressed() {
			boolean ret = testbtns[6];
			testbtns[6] = false;
			return ret;
		}
	} };
	private IElementDisplay el1 = new IElementDisplay() {

		String s = "";

		@Override
		public void setValue(String value) {
			s = value;
		}

		@Override
		public void refresh() {
			el1value = s;
		}

		@Override
		public String getName() {
			return "el1";
		}
	};
	private IElementDisplay el2 = new IElementDisplay() {

		String s = "";

		@Override
		public void setValue(String value) {
			s = value;
		}

		@Override
		public void refresh() {
			el2value = s;
		}

		@Override
		public String getName() {
			return "el2";
		}
	};
	private IDisplay display = new Display(new IElementDisplay[] { el1, el2 });

	@Test
	public void testRicezione() {
		Thread t = new Thread(new Runnable() {
			private Communicator server = new Communicator();

			@Override
			public void run() {
				String s;
				try {
					server.connect("server", SERVERPORT);
					Thread.sleep(2000);
					server.write(
							0,
							JSONConverter.SensorDataToJSON(new SensorData[] {
									new SensorData("el1", "val3"),
									new SensorData("el2", "val3") }));
					server.disconnect(0);
					server.closeServer(SERVERPORT);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		IControlUnit c = new ControlUnit(display, buttons);
		c.updateData(new SensorData[] { new SensorData("el1", "val1"),
				new SensorData("el2", "val1") });
		assertTrue("val1".equals(el1value));
		assertTrue("val1".equals(el2value));
		c.updateData(new SensorData[] { new SensorData("el1", "val2") });
		assertTrue("val2".equals(el1value));
		assertTrue("val1".equals(el2value));

		t.start();
		ISensorData[] data;

		try {
			c.connect("127.0.0.1", SERVERPORT);
			data = c.receiveData();
			c.updateData(data);
			assertTrue("val3".equals(el1value));
			assertTrue("val3".equals(el2value));
		} catch (Exception e) {
			fail("errore di comunicazione");
			e.printStackTrace();
		}

		try {
			data = c.receiveData();
			fail("receiveData errato");
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Test
	public void testInvio() {
		Thread t = new Thread(new Runnable() {
			private Communicator server = new Communicator();

			@Override
			public void run() {
				String s;
				try {

					server.connect("server", SERVERPORT);
					ok("server connesso");
					s = server.read(0);
					ok("Server ha letto "+s);
					s=JSONConverter.JSONToCommand(s);
					assertTrue("START".equals(s));
					server.disconnect(0);
					server.closeServer(SERVERPORT);
				} catch (Exception e) {
					fail("exception non prevista");
					e.printStackTrace();
				}
				System.out.println("ok");
			}
		});
		t.start();
		IControlUnit c = new ControlUnit(display, buttons);
		ISensorData[] data = new SensorData[] { new SensorData("el1", "val1"),
				new SensorData("el2", "val1") };
		c.updateData(data);
		try {

			c.connect("127.0.0.1", SERVERPORT);
			ok("client connesso");
			testbtns[0] = Boolean.TRUE;

			String s = c.readCommand();
			ok("comando letto "+s);
			assertTrue("START".equals(s));
			c.sendCommand(s);
			ok("comando inviato");

		} catch (Exception e) {
			fail("errore di comunicazione");
			e.printStackTrace();
		}
	}

	private void ok(String s) {
		System.out.println("ok "+s);
	}
	
	private void ok(){
		ok("");
	}
}
