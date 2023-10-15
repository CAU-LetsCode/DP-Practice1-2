package observerPractice;

import java.util.Observable;
import java.util.Observer;

public class IceCreamStore implements Observer, DisplayElement{
    private boolean sellingState;
    private float temperature;
    private float rainfall;
    Observable observable;

    public IceCreamStore(Observable observable){
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
            if(temperature >= 20){
                sellingState = true;
            } else {
                sellingState = false;
            }
            display();
        }
    }

    @Override
    public void display() {
        if(sellingState){System.out.println("Ice cream Sale !");}
    }


}
