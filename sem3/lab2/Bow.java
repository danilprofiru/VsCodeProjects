package lab2;

public class Bow extends Weapon {

    private int range;

    public Bow(String name, int damage, double weight, int range) {
        super(name, damage, weight);
        this.range = range;
    }

    public Bow() {
        this("Basic Bow", 8, 1.5, 50);
    }

    @Override
    public void attack() {
        System.out
                .println(getName() + " shoots an arrow with " + getDamage() + " damage at range " + range + " meters!");
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return super.toString() + ", range=" + range + " meters";
    }
}
