package lab2;

public class BowSpecifications extends Bow {

    private String material;
    private int levelResistance;

    public BowSpecifications(String name, int damage, double weight, int range, String material, int levelResistance) {
        super(name, damage, weight, range);
        this.material = material;
        this.levelResistance = levelResistance;
    }

    public BowSpecifications() {
        this("Basic Bow", 8, 1.5, 50, "Wood", 2);
    }

    @Override
    public void attack() {
        System.out
                .println(getName() + " shoots an arrow with " + getDamage() + " damage at range " + getRange()
                        + " meters!");
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getLevelResistance() {
        return levelResistance;
    }

    public void setLevelResistance() {
        this.levelResistance = levelResistance;
    }

    @Override
    public String toString() {
        return super.toString() + ", material=" + material + ", LevelResistance=" + levelResistance;
    }

}
