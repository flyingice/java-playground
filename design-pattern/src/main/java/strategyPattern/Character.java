package strategyPattern;

public abstract class Character {
    public void fight() {
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    WeaponBehavior weapon;
}
