package observerPattern;

import java.util.Random;

public class StatisticsDisplay implements Observer, DisplayElement {
    public StatisticsDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        display();
    }

    @Override
    public void display() {
        Random rand = new Random();
        // for simplicity
        System.out.printf("Avg/Max/Min temperature = %.1f/%.1f/%.1f%n", rand.nextFloat() * 100, rand.nextFloat() * 100, rand.nextFloat() * 100);
    }
}
