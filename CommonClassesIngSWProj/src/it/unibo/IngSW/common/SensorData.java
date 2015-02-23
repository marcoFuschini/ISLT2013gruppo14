package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorData implements ISensorData {
	private String name;
	private double val;
	public SensorData(String name,double val){
		this.name=name;
		this.val=val;
	}

	public void finalize() throws Throwable {

	}

	public String getName(){
		return name;
	}

	public double getValue(){
		return val;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(double value){
		this.val=value;
	}

}