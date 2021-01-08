package strategy;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("swinging a sword in the air");
    }
}
