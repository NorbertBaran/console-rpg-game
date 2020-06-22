package uj.io.rpg.events.shoop;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Location;
import uj.io.rpg.locations.LocationEnum;
import uj.io.rpg.locations.Shop;

import java.util.List;
import java.util.Scanner;

public abstract class ShopEvent extends Event {

    protected Equipment product;

    public ShopEvent(Hero hero, Equipment product) {
        super(hero);
        this.product=product;
    }

    protected void buy(){
        Scanner scanner=new Scanner(System.in);

        if(hero.getMoney()<product.getPrice())
            System.out.println("Cena zbyt wysoka. Tranzakcja zakończona niepowodzeniem.");
        else{
            System.out.println("Potwierdź zakup:\n[1.Akceptuj]]\n[2.Anuluj]");
            int acceptance=scanner.nextInt();
            if (acceptance==1) {
                System.out.println("Tranzakcja zakończona sukcesem.");
                hero.setEquipment(product);
                hero.setMoney(hero.getMoney()-product.getPrice());
            } else {
                System.out.println("Tranzakcja anulolwana.");
            }

        }
        System.out.println("Stan konta: "+hero.getMoney()+" sztuk złota");
        System.out.println();

        System.out.println("Czy chcesz kontynuować zakupy:\n[1.Kontynuuj]\n[2.Wyjdź]");
        int decision=scanner.nextInt();
        if(decision==1)
            nextLocation=new Shop(hero);
        else{
            System.out.println("Wybierz dalszy cel podróży:");
            List<LocationEnum> locations= LocationEnum.getLocations();
            for(int i=0; i<locations.size(); i++)
                System.out.println("["+(i+1)+"."+locations.get(i).getName()+"]");
            decision=scanner.nextInt();
            nextLocation=locations.get(decision-1).getLocation();
            nextLocation.setHero(hero);
        }
    }

}
