package uj.io.rpg.locations;

import uj.io.rpg.events.ocean.Escape;
import uj.io.rpg.events.ocean.Fight;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Ocean extends Location {

    public Ocean(Hero hero){
        super(hero);
        this.events=List.of(
                new Escape(hero),
                new Fight(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Ocean.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }

}
