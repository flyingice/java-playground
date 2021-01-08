package decorator;

public class Decaf implements Beverage {
    @Override
    public String description() {
        return "Decaf";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
