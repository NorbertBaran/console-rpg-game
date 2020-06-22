package uj.io.rpg.events.island;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;

public class Suicide extends Event {

    public Suicide(Hero hero){
        super(hero);
        this.eventName="Samobójstwo";
    }

    @Override
    public void execute() {
        nextLocation=new Exit(hero);
    }

}
