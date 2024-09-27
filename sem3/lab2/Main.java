package lab2;

// Main.java
public class Main {
    public static void main(String[] args) {
        Sword sword = new Sword("Excalibur", 15, 3.0, "Mythril");
        Bow bow = new Bow("block bow", 20, 4.0, 140);
        MagicWand wand = new MagicWand("Elder Wand", 25, 1.2, 50);
        BowSpecifications bow_2 = new BowSpecifications("Bow", 10, 2, 50, "Wood", 2);

        sword.attack();
        bow.attack();
        wand.attack();
        bow_2.attack();

        System.out.println(sword);
        System.out.println(bow);
        System.out.println(wand);
        System.out.println(bow_2);

        System.out.println("Total weapons created: " + Weapon.getWeaponCount());
    }
}
