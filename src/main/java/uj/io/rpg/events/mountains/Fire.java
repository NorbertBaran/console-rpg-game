package uj.io.rpg.events.mountains;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Mountains;
import uj.io.rpg.locations.Ocean;

import java.util.Random;

public class Fire extends Event {

    public Fire(Hero hero){
        super(hero);
        this.eventName="Ognisko";
    }

    @Override
    public void execute() {
        Random random=new Random();
        boolean drunk=random.nextBoolean();
        if(drunk){
            int headache=Math.abs(random.nextInt()) % 10 + 5;
            System.out.println("Podczas wieczornego ogniska zbyt mocno popiłeś. Budzisz\nsię następnego dnia w tym samym miejscu z ostrym bólem głowy\nTracisz "+headache+" punktów życia.");
            hero.setHp(hero.getHp()-headache);
            System.out.println("Stan życia: "+hero.getHp()+" pkt");
            nextLocation=new Mountains(hero);
        } else {
            System.out.println("Słuchając podczas ogniska wspaniałych historii o\npirackich łupach postanowiłeś sam ruszyć w ocean.");
            nextLocation=new Ocean(hero);
        }

    }

}
