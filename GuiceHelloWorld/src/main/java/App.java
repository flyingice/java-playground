import com.google.inject.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Guice demo");
        Injector injector = Guice.createInjector(new GreeterModule());
        GreeterFactory factory = injector.getInstance(GreeterFactory.class);
        factory.getInstance(GreeterModule.Option.POLITE).greet();
        factory.getInstance(GreeterModule.Option.RUDE).greet();
    }
}

