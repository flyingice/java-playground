package decorator;

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + "with Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.0;
    }
}
