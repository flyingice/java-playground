package observer;

public class ForecastDisplay implements Observer, DisplayElement {
    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        display();
    }

    @Override
    public void display() {
        // for simplicity
        System.out.println("Forecast: More of the same");
    }
}
