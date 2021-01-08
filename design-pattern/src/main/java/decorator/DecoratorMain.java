package decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DecoratorMain {
    private static final Logger LOGGER = LogManager.getLogger(DecoratorMain.class);

    public static void main(String[] args) {
        Beverage beverage = new Mocha(new Espresso());
        LOGGER.debug("{}: {}", beverage.description(), beverage.cost());
    }
}
