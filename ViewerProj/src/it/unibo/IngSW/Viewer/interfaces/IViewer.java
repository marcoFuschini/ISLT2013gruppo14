package DomainModel;
import Project.SensorData;

/**
 * @author Marco
 * @version 1.0
 * @created 04-feb-2015 17.03.00
 */
public interface IViewer {

	public IDisplay m_IDisplay;

	public SensorData[] receiveData();

	/**
	 * 
	 * @param data
	 */
	public void showSensorData(SensorData[] data);

	/**
	 * 
	 * @param stateData
	 */
	public void showState(SensorData stateData);

}