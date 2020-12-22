package strategyPattern;

public class Knight extends Character {
    public Knight() {
        weapon = new KnifeBehavior();
    }
}
