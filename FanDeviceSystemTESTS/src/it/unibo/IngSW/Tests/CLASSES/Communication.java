package it.unibo.IngSW.Tests.CLASSES;

import it.unibo.IngSW.Tests.CLASSES.interfaces.ICommunicator;

public class Communication implements ICommunicator {

	@Override
	public int connect(String ip, int port) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void disconnect(int connectionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public String read(int connectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(int connectionId, String data) {
		// TODO Auto-generated method stub

	}

}
