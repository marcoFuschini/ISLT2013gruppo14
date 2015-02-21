package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorData implements ISensorData {

	public SensorData(){

	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return "";
	}

	public double getValue(){
		return 0;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){

	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(double value){

	}

}