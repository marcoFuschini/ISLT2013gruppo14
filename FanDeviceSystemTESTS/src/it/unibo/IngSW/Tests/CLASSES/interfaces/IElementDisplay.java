package it.unibo.IngSW.Tests.CLASSES.interfaces;

/**
 * @author Fabio
 * @version 1.0
 * @created 17-feb-2015 18.00.01
 */
public interface IElementDisplay {

	public String getName();

	public void refresh();

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value);

}