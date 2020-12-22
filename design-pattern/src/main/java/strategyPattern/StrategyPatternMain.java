package strategyPattern;

import java.util.stream.Stream;

public class StrategyPatternMain {
    public static void main(String[] args) {
        Character[] characters = {new King(), new Queen(), new Knight(), new Troll()};
        Stream.of(characters).forEach(Character::fight);
    }
}
