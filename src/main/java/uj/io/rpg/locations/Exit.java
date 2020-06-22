package uj.io.rpg.locations;

import uj.io.rpg.hero.Hero;

public class Exit extends Location {
    public Exit(Hero hero) {
        super(hero);
    }

    @Override
    public void execute() {
        printDescription("locations/Exit.txt");
        System.out.println();
        System.out.println("Twój wynik to:"+hero.getMoney()+" sztuk złota.");
        System.exit(0);
    }
}
