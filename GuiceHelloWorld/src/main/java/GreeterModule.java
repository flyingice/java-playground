import com.google.inject.*;
import com.google.inject.multibindings.MapBinder;

public class GreeterModule extends AbstractModule {
    public enum Option {
        POLITE,
        RUDE;
    }

    @Override
    protected void configure() {
        MapBinder<Option, Greeter> mapBinder = MapBinder.newMapBinder(binder(), Option.class, Greeter.class);
        mapBinder.addBinding(Option.POLITE).to(GreeterPolite.class);
        mapBinder.addBinding(Option.RUDE).to(GreeterRude.class);

        bind(GreeterFactory.class).in(Singleton.class);
    }
}
