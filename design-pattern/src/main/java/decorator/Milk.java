package decorator;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + " with Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}
