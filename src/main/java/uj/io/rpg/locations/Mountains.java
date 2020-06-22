package uj.io.rpg.locations;

import uj.io.rpg.events.mountains.Climbing;
import uj.io.rpg.events.mountains.Dancing;
import uj.io.rpg.events.mountains.Fire;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Mountains extends Location {

    public Mountains(Hero hero){
        super(hero);
        this.events=List.of(
                new Climbing(hero),
                new Dancing(hero),
                new Fire(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Mountains.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }

}
