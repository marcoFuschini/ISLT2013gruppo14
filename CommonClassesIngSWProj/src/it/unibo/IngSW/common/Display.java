package it.unibo.IngSW.common;
import java.util.ArrayList;

import javax.swing.JFrame;

import it.unibo.IngSW.common.interfaces.IDisplay;
import it.unibo.IngSW.common.interfaces.IElementDisplay;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.33
 */
public class Display extends JFrame implements IDisplay {

	private ArrayList<IElementDisplay> elements=new ArrayList<IElementDisplay>();
	
	public Display(IElementDisplay[] elements){
		for(int i=0;i<elements.length;i++){
			this.elements.add(elements[i]);
		}
		
	}

	public void finalize() throws Throwable {

	}

	public void refresh(){
		for(IElementDisplay el:elements){
			el.refresh();
		}
		this.repaint();
	}

	/**
	 * 
	 * @param value
	 * @param name
	 */
	public boolean writeData(String value, String name){
		for(IElementDisplay el:elements){
			if(el.getName().equals(name)){
				el.setValue(value);
			}
		}
		return false;
	}

}