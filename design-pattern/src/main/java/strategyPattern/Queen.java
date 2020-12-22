package strategyPattern;

public class Queen extends Character {
    public Queen() {
        weapon = new BowAndArrowBehavior();
    }
}
