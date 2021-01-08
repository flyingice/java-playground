package decorator;

public class HouseBlend implements Beverage {
    @Override
    public String description() {
        return "House blend";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
