package it.unibo.IngSW.common.interfaces;
import DomainModel.IElementDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface ISensorDisplay extends IElementDisplay {

	/**
	 * 
	 * @param data
	 */
	public void updateView(String data);

}