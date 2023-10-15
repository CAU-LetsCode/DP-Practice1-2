package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    Observable observable;
    private float temperature;
    private float rainfall;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WhetherDataSubject) {
            WhetherDataSubject whetherDataSubject = (WhetherDataSubject) obs;
            this.temperature = whetherDataSubject.getTemperature();
            this.rainfall = whetherDataSubject.getRainfall();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("\n===== Current state ===== \n Temperature : %.1f'c \n Rainfall : %.1fmm \n=========================\n",
                temperature, rainfall);
    }



}
