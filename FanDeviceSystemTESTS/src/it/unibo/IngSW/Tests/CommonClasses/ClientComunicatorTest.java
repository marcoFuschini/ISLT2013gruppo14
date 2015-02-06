package it.unibo.IngSW.Tests.CommonClasses;

import static org.junit.Assert.*;
import it.unibo.IngSW.FanDevice.ServerComunicator;
import it.unibo.IngSW.common.ClientComunicator;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClientComunicatorTest {

	private ClientComunicator client;
	private ServerComunicator server;
	@BeforeClass
	public void init(){
		client=new ClientComunicator();
		server=new ServerComunicator();
	}
	
	@Test
	public void testConnect() {
		server.connect("server");		
		assertTrue(client.connect("127.0.0.1"));
	}

	@Test
	public void testReadData() {
		server.writeData("data");
		assertEquals("data", client.readData());
	}

	@Test
	public void testWriteData() {
		client.writeData("example");
		assertEquals("data",server.readData());
	}

	@Test
	public void testDisconnect() {
		assertTrue(client.disconnect());
	}

}
