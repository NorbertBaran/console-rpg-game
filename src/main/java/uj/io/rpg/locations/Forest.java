package uj.io.rpg.locations;

import uj.io.rpg.events.forest.Mushrooms;
import uj.io.rpg.events.forest.River;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Forest extends Location {

    public Forest(Hero hero){
        super(hero);
        this.events=List.of(
                new Mushrooms(hero),
                new River(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Forest.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }

}
