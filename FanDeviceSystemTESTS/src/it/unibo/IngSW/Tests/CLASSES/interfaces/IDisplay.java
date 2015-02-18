package it.unibo.IngSW.Tests.CLASSES.interfaces;

/**
 * Il wrapper pu� essere messo nella fase di progetto: ha solo
 * writesensordata(ISensorData[])
 * @author Fabio
 * @version 1.0
 * @created 17-feb-2015 18.00.01
 */
public interface IDisplay {

	//public ArrayList<IElementDisplay> m_IElementDisplay;

	public void refresh();

	/**
	 * 
	 * @param value
	 * @param name
	 */
	public boolean writeData(String value, String name);

}