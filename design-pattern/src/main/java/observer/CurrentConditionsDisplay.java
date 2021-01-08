package observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    public CurrentConditionsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherData) {
            // I am only interested in a subset of source data
            WeatherData weatherData = (WeatherData) observable;
            temperature = weatherData.getTemperature();
            humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.1fF degrees and %.1f%% humidity%n", temperature, humidity);
    }

    private float temperature;
    private float humidity;
}
