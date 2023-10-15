package observerPractice;

public class WhetherSimulator {
	
	
	public static void main(String[] args) {


		WhetherDataSubject wdSubject = new WhetherDataSubject();

		//observer objects
		ClothingStore clothingStore = new ClothingStore(wdSubject);
		UmbrellaStore umbrellaStore = new UmbrellaStore(wdSubject);
		IceCreamStore iceCreamStore = new IceCreamStore(wdSubject);
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(wdSubject);

		wdSubject.setMeasurements(25.0f, 0.0f);
		wdSubject.setMeasurements(10.0f, 10.0f);
		wdSubject.setMeasurements(16.0f, 1.0f);


	}
}
