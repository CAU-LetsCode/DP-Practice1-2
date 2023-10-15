package headfirst.observer.weatherobservable;

import java.util.*;

public class AverageDisplay implements Observer, DisplayElement {

    private double tempAvg;
    private ArrayList<Float> temperatureList;

    public AverageDisplay(Observable observable) {
        observable.addObserver(this);
        temperatureList = new ArrayList<Float>();
    }

    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)obs;
            if(temperatureList.size()>9){temperatureList.remove(0);}
            temperatureList.add(weatherData.getTemperature());
            display();
        }
    }

    public void display() {
        System.out.println("\nAverage Temperature: " + temperatureList
                .stream()
                .mapToDouble(a -> a)
                .average().getAsDouble()
                + "F degrees");
    }
}
