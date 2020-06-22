package uj.io.rpg.hero;

public class Hero {
    private int hp;
    private Equipment equipment;
    int money;

    public Hero(){
        this.hp=100;
        this.equipment=Equipment.NOTHING;
        this.money=100;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
