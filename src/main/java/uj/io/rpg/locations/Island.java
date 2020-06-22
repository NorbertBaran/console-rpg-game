package uj.io.rpg.locations;

import uj.io.rpg.events.island.Suicide;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Island extends Location {

    public Island(Hero hero){
        super(hero);
        this.events=List.of(
                new Suicide(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Island.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }

    @Override
    public Location nextLocation() {
        return nextLocation;
    }
}
