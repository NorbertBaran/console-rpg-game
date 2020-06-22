package uj.io.rpg.locations;

import uj.io.rpg.events.desert.Camel;
import uj.io.rpg.events.desert.Jeep;
import uj.io.rpg.hero.Hero;

import java.util.List;

public class Desert extends Location{

    public Desert(Hero hero){
        super(hero);
        this.events=List.of(
                new Camel(hero),
                new Jeep(hero)
        );
    }

    @Override
    public void execute() {
        printDescription("locations/Desert.txt");
        printEvents(events);
        makeEvent(scanner.nextInt()-1);
    }

}
