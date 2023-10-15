package observerPractice;


import java.util.Observable;
import java.util.Observer;

public class WhetherDataSubject extends Observable {
	private float temperature = 25.0f;
	private float rainfall = 0.0f;

	// default constructor
	public WhetherDataSubject() {  }

	public void notifyDataSetChanged(){
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float rainfall) {
		this.temperature = temperature;
		this.rainfall = rainfall;
		notifyDataSetChanged();
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyDataSetChanged();
	}
	
	public void setRainfall(float rainfall) {
		this.rainfall = rainfall;
		notifyDataSetChanged();
	}

	public float getTemperature(){ return temperature; }
	public float getRainfall() { return rainfall; }

}
