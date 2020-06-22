package uj.io.rpg.events.desert;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Forest;
import uj.io.rpg.locations.Mountains;

import java.util.Random;

public class Jeep extends Event {

    public Jeep(Hero hero){
        super(hero);
        this.eventName="Jeep";
    }

    @Override
    public void execute() {
        Random random=new Random();
        int fuelPrice=Math.abs(random.nextInt()) % 1300;
        int fuel=fuelPrice / hero.getEquipment().getAttack();
        if(fuel>hero.getMoney()){
            System.out.println("Skończyło ci się paliwo. Niestety nie udało ci się opuścić pustyni.\nNie stać cię na wystarczającą ilość paliwa.\nNic już nie możesz na to poradzić.\n" +
                    "Koszt paliwa: "+fuel+"\nStan złota: "+hero.getMoney()+" sztuk");
            nextLocation=new Exit(hero);
        } else {
            hero.setMoney(hero.getMoney()-fuel);
            nextLocation=new Mountains(hero);
            System.out.println("Podróż była długa i droga. Na szczęście zakończyła się sukcesem.\n"+"Cena paliwa: "+fuelPrice+"\nKoszt paliwa, po zaatakowaniu sprzedawcy: "+fuel+"\nStan złota po opłaceniu paliwa: "+hero.getMoney()+" sztuk");
        }
    }

}
