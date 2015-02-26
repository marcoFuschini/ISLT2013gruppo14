package it.unibo.IngSW.FanDevice;

import it.unibo.IngSW.FanDevice.interfaces.IFanDeviceDecorator;
import it.unibo.IngSW.FanDevice.interfaces.ISensor;
import it.unibo.IngSW.FanDevice.interfaces.ISensorDataBuffer;
import it.unibo.IngSW.FanDevice.interfaces.ISensorPoller;
import it.unibo.IngSW.Simulatori.SimFanDevice;
import it.unibo.IngSW.Simulatori.SimTachometer;
import it.unibo.IngSW.Simulatori.SimThermometer;
import it.unibo.IngSW.common.Command;
import it.unibo.IngSW.common.FanSpeed;
import it.unibo.IngSW.common.SensorName;
import it.unibo.IngSW.common.interfaces.IFanDevice;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class FanDeviceMain {

	private static final double TLIMIT1 = 27.0;
	private static final double TLIMIT2 = 32.0;
	private static final int CUPORT = 10001;
	private static final int VPORT = 10002;

	private static boolean run = true;

	public FanDeviceMain() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Porte di ascolto: ControlUnit="+CUPORT+" Viewers="+VPORT);
		ISensorDataBuffer buffer = new SensorDataBuffer(2048);
		IFanDevice fan = new SimFanDevice();
		IFanDeviceDecorator fd = new FanDeviceDecorator(buffer, fan);
		ISensor tach = new Sensor(new SimTachometer((SimFanDevice) fan),
				SensorName.SPEED.toString());
		ISensor term = new Sensor(
				new SimThermometer((SimFanDevice) fan, 20, 1),
				SensorName.TEMPERATURE.toString());
		ISensor[] tachArray = new ISensor[] { tach };
		ISensor[] termArray = new ISensor[] { term };
		ISensorPoller tachPoller = new SensorPoller(tachArray, buffer, 0);
		ISensorPoller termPoller = new SensorPoller(termArray, buffer, 1500);
		try {
			scrivi("Mi metto in ascolto");
			fd.connect(VPORT, CUPORT);
			System.out.println("CU connected");
		} catch (Exception e) {
//			e.printStackTrace();
		}
		new Thread(tachPoller).start();
		new Thread(termPoller).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Double temp = null;
					Double oldTemp = null;
					while (run) {

						ISensorData[] data = fd.getSensorData();
						scrivi("dati ottenuti");
						fd.sendData(data);
						scrivi("dati inviati");

						for (ISensorData d : data) {

							if (d.getName().equals(
									SensorName.TEMPERATURE.toString())) {
								temp = Double.parseDouble(d.getValue());
								if (oldTemp != null) {
									if (oldTemp <= TLIMIT2 && temp > TLIMIT2) {
										System.out.println("autostop");
										fd.stop();
									} else if (oldTemp <= TLIMIT1
											&& temp > TLIMIT1) {
										System.out.println("autoinc");
										fd.incSpeed();
									}
								}
								oldTemp = temp;
							}
						}
					}
				} catch (Exception e) {
//					e.printStackTrace();
				}
				scrivi("exiting data thread");
			}

		}).start();

		try {
			while (run) {
				String cmd = fd.receiveCommand();
				scrivi("ricevuto comando " + cmd);
				Command command = Command.StringToCommand(cmd);
				switch (command) {
				case START:
					fd.start();
					break;
				case STOP:
					fd.stop();
					break;
				case INCSPEED:
					fd.incSpeed();
					break;
				case DECSPEED:
					fd.decSpeed();
					break;
				case LOWSPEED:
					fd.setSpeed(FanSpeed.LOWSPEED);
					break;
				case MEDIUMSPEED:
					fd.setSpeed(FanSpeed.MEDIUMSPEED);
					break;
				case HIGHSPEED:
					fd.setSpeed(FanSpeed.HIGHSPEED);
					break;
				default:
				}
			}
		} catch (Exception e) {
			fd.disconnect();
			run = false;
			tachPoller.kill();
			termPoller.kill();
//			e.printStackTrace();
		}
		while(Thread.activeCount()>2){
			scrivi("Thread attivi="+Thread.activeCount());
		}
		scrivi("Main Thread terminato con " + Thread.activeCount() + " attivi");
		System.exit(0);		
	}

	private static void scrivi(String string) {
		//System.out.println(string);
	}

}