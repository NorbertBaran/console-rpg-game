package uj.io.rpg.hero;

public enum Equipment {
    NOTHING(1, 1, 0, "Nic"),
    FORK(10, 10, 100, "Nóż"),
    KNIFE(20, 15, 500, "Widelec"),
    GUN(30, 30, 2000, "Postolet");

    private final int attack;
    private final int protection;
    private final int price;
    private final String name;
    Equipment(int attack, int protection, int price, String name){
        this.attack=attack;
        this.protection=protection;
        this.price=price;
        this.name=name;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
