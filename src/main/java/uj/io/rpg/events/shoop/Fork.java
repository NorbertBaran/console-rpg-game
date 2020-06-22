package uj.io.rpg.events.shoop;

import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;

public class Fork extends ShopEvent{

    public Fork(Hero hero){
        super(hero, Equipment.FORK);
        this.eventName="Widelec (Cena: "+Equipment.FORK.getPrice()+" sztuk złota)";
    }

    @Override
    public void execute() {
        buy();
    }

}
