package observer;

public class WeatherData extends AbstractObservable {
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    // Simulate the status change, for test purpose only.
    // It is not need for the Observer pattern
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        statusChanged();
    }

    private float temperature;
    private float humidity;
    private float pressure;
}
