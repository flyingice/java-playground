package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class AbstractObservable implements Observable {
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.stream().forEach(ob -> ob.update(this));
    }

    // The function is triggered every time there is a status change on Observable
    public void statusChanged() {
        notifyObservers();
    }

    List<Observer> observerList = new ArrayList<>();
}
