import com.google.inject.Inject;

import java.util.Map;
import java.util.Random;

public class GreeterFactory {
    private final Map<GreeterModule.Option, Greeter> mapBinder;

    @Inject
    public GreeterFactory(Map<GreeterModule.Option, Greeter> mapBinder) {
        this.mapBinder = mapBinder;
    }

    public Greeter getInstance(GreeterModule.Option option) {
        return mapBinder.get(option);
    }
}
