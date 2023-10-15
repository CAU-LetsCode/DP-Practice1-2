package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class ClothingStore implements Observer,DisplayElement{
	private static final int SUMMER_CLOTHS = 1;
	private static final int WINTER_CLOTHS = 2;
	
	private int state = SUMMER_CLOTHS;;

	private float temperature;
	private float rainfall;
	Observable observable;
	
	public ClothingStore(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WhetherDataSubject) {
			WhetherDataSubject whetherDataSubject = (WhetherDataSubject)obs;
			this.temperature = whetherDataSubject.getTemperature();
			this.rainfall = whetherDataSubject.getRainfall();
			if(temperature >= 15.0f) // when temperature exceeds 15.0'c
				state = SUMMER_CLOTHS; // selling summer cloths
			else // when temperature < 15.0
				state = WINTER_CLOTHS;
			display();
		}
	}

	@Override
	public void display() { //kindOfSellingCloths
		System.out.println("Selling " + ((state == SUMMER_CLOTHS) ? "Summer" : "Winter") + " cloths !");
	}


}
