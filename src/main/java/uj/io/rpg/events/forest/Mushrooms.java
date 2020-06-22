package uj.io.rpg.events.forest;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Location;
import uj.io.rpg.locations.LocationEnum;

import java.util.List;
import java.util.Random;

public class Mushrooms extends Event {

    public Mushrooms(Hero hero){
        super(hero);
        this.eventName="Grzyby";
    }

    private void randLocation(){
        Random random=new Random();

        List<LocationEnum> locations= LocationEnum.getLocations();
        int place=Math.abs(random.nextInt()) % locations.size();
        nextLocation=locations.get(place).getLocation();
        nextLocation.setHero(hero);
    }

    @Override
    public void execute() {
        Random random=new Random();
        double mushroomHealthy=Math.abs(random.nextDouble());
        int healthy=Math.abs(random.nextInt()) % 50 + 1;
        if(mushroomHealthy>0.30){
            System.out.println("Zdobyte przez ciebie grzyby dostarczyły ci energii.\nOtrzymujesz "+healthy+" punktów życia.\nNiestey niektóre z grzybów okazały się halucynogenne.\n" +
                    "Nie są one szkodliwe lecz w wyniku ich sporzycia nie jesteś w\nstaniekontrolować własnych decyzji.\nNastępnego dnia budzisz się w przypadkowym miejscu");
            hero.setHp(hero.getHp()+healthy);
            randLocation();

        } else {
            if(hero.getHp()<50-hero.getEquipment().getProtection()){
                System.out.println("Natrafiłeś na trującego grzyba. Jesteś niestety zbyt słaby,\naby sobie poradzić z jego konsekwencjami. Tracisz pozostałe punkty życia.");
                nextLocation=new Exit(hero);
            } else {
                System.out.println("Natrafiłeś na trującego grzyba. Na szczęście twój silny\norganizm zwalczył truciznę. Tracisz "+(50-hero.getEquipment().getProtection())+" życia.\n" +
                        "Następnego dnia budzisz się w przypadkowym miejscu.");
                hero.setHp(hero.getHp()-(50-hero.getEquipment().getProtection()));
                randLocation();
            }
        }
    }

}
