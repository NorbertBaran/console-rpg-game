package uj.io.rpg.events.shoop;

import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;

public class Gun extends ShopEvent {

    public Gun(Hero hero){
        super(hero, Equipment.GUN);
        this.eventName="Pistolet (Cena: "+ Equipment.GUN.getPrice() +" sztuk złota)";
    }

    @Override
    public void execute() {
        buy();
    }
}
