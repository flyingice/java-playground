package strategyPattern;

public class King extends Character {
    public King() {
        weapon = new SwordBehavior();
    }
}
