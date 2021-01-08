package decorator;

public class DarkRoast implements Beverage {
    @Override
    public String description() {
        return "Dark roast";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
