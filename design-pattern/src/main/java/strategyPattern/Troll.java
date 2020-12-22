package strategyPattern;

public class Troll extends Character {
    public Troll() {
        weapon = new AxeBehavior();
    }
}
