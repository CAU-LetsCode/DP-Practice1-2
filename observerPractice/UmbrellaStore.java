package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class UmbrellaStore implements Observer, DisplayElement{
	
	private boolean sellingState;
	private float temperature;
	private float rainfall;
	Observable observable;

	// default constructor
	public UmbrellaStore(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		sellingState = false;
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WhetherDataSubject) {
			WhetherDataSubject whetherDataSubject = (WhetherDataSubject) obs;
			this.temperature = whetherDataSubject.getTemperature();
			this.rainfall = whetherDataSubject.getRainfall();
			if (rainfall >= 5.0f) {// when rainfall exceeds 5.0mm
				sellingState = true; // selling umbrella
			} else {// when rainfall < 5.0
				sellingState = false;
			}
			display();
		}
	}

	@Override
	public void display() { //isSelling()
		if(sellingState){System.out.println("Umbrellas Sale !");}
	}


}
