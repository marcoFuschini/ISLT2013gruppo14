package it.unibo.IngSW.Simulatori;

import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.interfaces.ITachometer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class SimTachometer implements ITachometer {

	private SimFanDevice fan;
	private ArrayBlockingQueue<Double> bq = new ArrayBlockingQueue<Double>(1);
	private Thread t;
	private boolean loop = true;
	private Random r = new Random();

	public SimTachometer(SimFanDevice fan) {
		this.fan = fan;
		t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (loop) {
					try {
						Thread.sleep(Integer.toUnsignedLong(r.nextInt(1000)) + 200);
						double speed;
						if (fan.getSpeed() == FanSpeed.ZEROSPEED) {
							speed = 0;
						} else {
							int deltaSpeed = fan.getSpeed().getRevolMax()
									- fan.getSpeed().getRevolMin();
							speed = (r.nextDouble() * deltaSpeed)
									+ fan.getSpeed().getRevolMin();
						}
						bq.put(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}

	@Override
	public double getValue() {
		try {
			return bq.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return -1;
		}

	}

}
