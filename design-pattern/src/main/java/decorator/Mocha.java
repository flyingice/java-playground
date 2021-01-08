package decorator;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " with Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}
