package observer;

public interface Observer {
    // pull model: observer has to fetch the data from the observable by itself
    // An additional parameter of type Object is needed to convey the data in case of push
    void update(Observable observable);
}
