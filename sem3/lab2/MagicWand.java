package lab2;

// MagicWand.java
public class MagicWand extends Weapon {

    private int magicPower;

    public MagicWand(String name, int damage, double weight, int magicPower) {
        super(name, damage, weight);
        this.magicPower = magicPower;
    }

    public MagicWand() {
        this("Basic Wand", 5, 1.0, 20);
    }

    @Override
    public void attack() {
        System.out.println(
                getName() + " casts a spell with " + getDamage() + " damage and magic power " + magicPower + "!");
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    @Override
    public String toString() {
        return super.toString() + ", magicPower=" + magicPower;
    }
}
