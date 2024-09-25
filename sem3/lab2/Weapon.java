package lab2;

public abstract class Weapon {

    private String name;
    private int damage;
    private double weight;

    private static int weaponCount = 0;

    public Weapon(String name, int damage, double weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        weaponCount++;
    }

    public Weapon() {
        this("Unknown", 0, 0.0);
    }

    public abstract void attack();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static int getWeaponCount() {
        return weaponCount;
    }

    @Override
    public String toString() {
        return "Weapon{name='" + name + "', damage=" + damage + ", weight=" + weight + "}";
    }
}
