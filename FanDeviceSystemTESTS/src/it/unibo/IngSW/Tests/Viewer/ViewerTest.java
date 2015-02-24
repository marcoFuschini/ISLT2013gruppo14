package it.unibo.IngSW.Tests.Viewer;

import static org.junit.Assert.*;
import it.unibo.IngSW.Viewer.Viewer;
import it.unibo.IngSW.common.Display;
import it.unibo.IngSW.common.SensorData;
import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;
import it.unibo.IngSW.common.interfaces.ISensorData;
import it.unibo.IngSW.utils.JSONConverter;
import it.unibo.IngSWBasicComponents.Communicator;

import org.junit.BeforeClass;
import org.junit.Test;

public class ViewerTest {

	private final int SERVERPORT=10001;
	private String el1value = "";
	private String el2value = "";
	private Communicator server=new Communicator();
	private IElementDisplay el1 = new IElementDisplay() {

		String s="";
		@Override
		public void setValue(String value) {
			s=value;
		}

		@Override
		public void refresh() {
			el1value=s;
		}

		@Override
		public String getName() {
			return "el1";
		}
	};
	private IElementDisplay el2 = new IElementDisplay() {

		String s="";
		@Override
		public void setValue(String value) {
			s=value;
		}

		@Override
		public void refresh() {
			el2value=s;
		}

		@Override
		public String getName() {
			return "el2";
		}
	};
	private IDisplay display = new Display(new IElementDisplay[] { el1, el2 });
	private Thread t = new Thread(new Runnable() {
		
		@Override
		public void run() {
			String s;
			try {
				server.connect("server", SERVERPORT);
				Thread.sleep(2000);
				server.write(0, JSONConverter.SensorDataToJSON(new SensorData[]{new SensorData("el1", "val3"),new SensorData("el2","val3")}));
				server.disconnect(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	@Test
	public void testViewer() {
		
		Viewer v = new Viewer(display);
		v.updateData(new SensorData[]{new SensorData("el1", "val1"),new SensorData("el2","val1")});
		assertTrue("val1".equals(el1value));
		assertTrue("val1".equals(el2value));
		v.updateData(new SensorData[]{new SensorData("el1", "val2")});
		assertTrue("val2".equals(el1value));
		assertTrue("val1".equals(el2value));
				
		t.start();
		ISensorData[] data;
		
		try {
			v.connect("127.0.0.1",SERVERPORT);
			data=v.receiveData();
			v.updateData(data);
			assertTrue("val3".equals(el1value));
			assertTrue("val3".equals(el2value));
		} catch (Exception e) {
			fail("errore di comunicazione");
			e.printStackTrace();
		}
		
		try {
			data=v.receiveData();
			fail("receiveData errato");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

}
