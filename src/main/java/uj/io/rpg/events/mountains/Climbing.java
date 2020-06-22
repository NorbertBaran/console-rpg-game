package uj.io.rpg.events.mountains;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Forest;
import uj.io.rpg.locations.Mountains;

import java.util.Random;

public class Climbing extends Event {

    public Climbing(Hero hero){
        super(hero);
        this.eventName="Wspinaczka";
    }

    @Override
    public void execute() {
        Random random=new Random();
        double skills=Math.abs(random.nextDouble());
        if(skills>0.56){
            System.out.println("Lokalne legendy okazały się być prawdziwe.\nNa szczycie góry odnalazłeś napój uzdrawiający.\nUzyskujesz 30 punktów życia.");
            hero.setHp(hero.getHp()+30);
            System.out.println("Posiadasz: "+hero.getHp()+" punktów życia.");
            System.out.println("Wracasz z gór u podnuża których odkrywasz las.");
            nextLocation=new Forest(hero);
        } else {
            int hurt=100/hero.getEquipment().getProtection() + Math.abs(random.nextInt()) % 10;
            System.out.println("Wspinaczka okazała się zbyt trudna. Spadłeś tracąc "+hurt+ " punktów życia");
            if(hero.getHp()<hurt){
                System.out.println("Obrażenia okazały się zbyt ciężkie. Tracisz pozostałę punkty życia");
                nextLocation=new Exit(hero);
            } else {
                hero.setHp(hero.getHp()-hurt);
                nextLocation= new Mountains(hero);
            }
        }
    }

}
