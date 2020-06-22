package uj.io.rpg.events.desert;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Desert;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Forest;

import java.util.Random;

public class Camel extends Event {

    public Camel(Hero hero){
        super(hero);
        this.eventName="Wielbłąd";
    }

    @Override
    public void execute() {
        Random random=new Random();
        boolean success=random.nextBoolean();
        if(success){
            int price=Math.abs(random.nextInt()) % 50 + 50;
            System.out.println("Udało ci się dotrzeć do celu. Sprzedajesz wielbłąda za bezcen.");
            System.out.println("Cena wielbłąda: "+price);
            hero.setMoney(hero.getMoney()+price);
            System.out.println("Stan złota: "+hero.getMoney());
            nextLocation= new Forest(hero);
        } else {
            System.out.println("Nie udało ci się dotrzeć do celu. Wielbłąd okazał się zbyt słaby.\nW wyniku ciężkiej, lecz nieudanej podróży tracisz dużo siły");
            int hurt=Math.abs(random.nextInt()) % 20 + 30;
            if(hero.getHp()<hurt){
                System.out.println("Straciłeś zbyt dużo siły.");
                nextLocation=new Exit(hero);
            } else{
                hero.setHp(hero.getHp()-hurt);
                System.out.println("Liczba punktów życia: "+hero.getHp()+"pkt");
                nextLocation=new Desert(hero);
            }

        }
    }

}
