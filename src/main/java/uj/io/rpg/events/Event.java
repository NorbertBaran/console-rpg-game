package uj.io.rpg.events;

import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Location;

public abstract class Event {

    protected String eventName;
    protected Location nextLocation;
    protected Hero hero;

    public Event(Hero hero){
        this.hero=hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getEventName(){
        return eventName;
    }

    public abstract void execute();

    public Location getNextLocation(){
        return nextLocation;
    }
}
