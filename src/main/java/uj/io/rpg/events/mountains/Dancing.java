package uj.io.rpg.events.mountains;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Shop;

import java.util.Random;

public class Dancing extends Event {

    public Dancing(Hero hero){
        super(hero);
        this.eventName="Potańcówka";
    }

    @Override
    public void execute() {
        System.out.println("Odbyłeś wspaniałą potańcówkę.\nByła to zabawa, która nie niosła ze sobą żadnego ryzyka, więc nic nie tracisz.\n" +
                "Odpoczęty chcesz ruszyć w dalszą podróż.\nPrzed odejściem zostałeś jeszcze zaproszony do lokalnego sklepu\nz bronią. Sprawdź czy jest tam coś na co cię stać.");
        nextLocation=new Shop(hero);
    }

}
