package it.unibo.IngSW.common.interfaces;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 17.06.29
 */
public interface ISensorData {

	public String getName();

	public double getValue();

	/**
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * 
	 * @param value
	 */
	public void setValue(double value);

}