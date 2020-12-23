package observerPattern;

import java.util.Arrays;
import java.util.List;

public class ObserverPatternMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        List<Observer> observerList = Arrays.asList(new CurrentConditionsDisplay(weatherData), new StatisticsDisplay(weatherData), new ForecastDisplay(weatherData));

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
