package Project;

import it.unibo.IngSW.common.interfaces.ISensorDisplay;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.03
 */
public class TachometerDisplay extends JComponent implements ISensorDisplay {

	public TachometerDisplay(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getName(){
		return "";
	}

	public boolean isInput(){
		return false;
	}

	/**
	 * 
	 * @param data
	 */
	public void updateView(String data){

	}

}