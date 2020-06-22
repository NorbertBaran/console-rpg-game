package uj.io.rpg.events.ocean;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Island;
import uj.io.rpg.locations.Mountains;
import uj.io.rpg.locations.Ocean;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Escape extends Event {

    public Escape(Hero hero){
        super(hero);
        this.eventName="Ucieczka";
        this.hero=hero;
    }

    @Override
    public void execute() {
        Random random=new Random();
        boolean escape=random.nextBoolean();
        if(escape){
            nextLocation=new Ocean(hero);
            System.out.println("Nie udało ci się uciec niezauważonym.\nTwoja wyprawa morska jest kontynuowana");
        }
        else{
            System.out.println("Udało ci się uciec niezauważony przez piratów");
            double crash=random.nextDouble();
            if(crash>0.6){
                nextLocation=new Island(hero);
                System.out.println("Twoja łódź uległa poważnym uszkodzeniom.");
            } else {
                nextLocation=new Mountains(hero);
            }
        }

    }

}
