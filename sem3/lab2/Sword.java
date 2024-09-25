package lab2;

public class Sword extends Weapon {

    private String bladeMaterial;

    public Sword(String name, int damage, double weight, String bladeMaterial) {
        super(name, damage, weight);
        this.bladeMaterial = bladeMaterial;
    }

    public Sword() {
        this("Basic Sword", 10, 2.5, "Steel");
    }

    @Override
    public void attack() {
        System.out.println(getName() + " slashes with " + getDamage() + " damage!");
    }

    public String getBladeMaterial() {
        return bladeMaterial;
    }

    public void setBladeMaterial(String bladeMaterial) {
        this.bladeMaterial = bladeMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + ", bladeMaterial='" + bladeMaterial + "'";
    }
}
