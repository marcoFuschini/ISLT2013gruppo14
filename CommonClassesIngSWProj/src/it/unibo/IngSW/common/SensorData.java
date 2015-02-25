package it.unibo.IngSW.common;
import it.unibo.IngSW.common.interfaces.ISensorData;

/**
 * @author Fabio
 * @version 1.0
 * @created 21-feb-2015 16.50.34
 */
public class SensorData implements ISensorData {
	private SensorName name;
	private String val;
	public SensorData(SensorName name,String val){
		this.name=name;
		this.val=val;
	}

	public void finalize() throws Throwable {

	}

	public SensorName getName(){
		return name;
	}

	public String getValue(){
		return val;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(SensorName name){
		this.name=name;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value){
		this.val=value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorData other = (SensorData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}

}