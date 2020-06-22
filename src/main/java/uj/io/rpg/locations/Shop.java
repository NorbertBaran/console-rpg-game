package uj.io.rpg.locations;

import uj.io.rpg.events.shoop.Fork;
import uj.io.rpg.events.shoop.Gun;
import uj.io.rpg.events.shoop.Knife;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Shop extends Location {

    public Shop(Hero hero){
        super(hero);
        this.events= List.of(
                new Fork(hero),
                new Knife(hero),
                new Gun(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Shop.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }
}
