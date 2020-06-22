package uj.io.rpg.events.shoop;

import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;

public class Knife extends ShopEvent {

    public Knife(Hero hero){
        super(hero, Equipment.KNIFE);
        this.eventName="Nóż (Cena: "+ Equipment.KNIFE.getPrice() +" sztuk złota)";
    }

    @Override
    public void execute() {
        buy();
    }
}
