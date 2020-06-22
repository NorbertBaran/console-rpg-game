package uj.io.rpg.events.ocean;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.LocationEnum;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fight extends Event {

    public Fight(Hero hero){
        super(hero);
        this.eventName="Walka";
    }

    @Override
    public void execute() {
        System.out.println("Postanowiłeś podjąć się walki z okrótnymi piratami.\nPamiętaj że walczysz zarówno o życie jak i skarb piracki.\n" +
                "Im większą ochronę posiadasz tym mniejsze rany otrzymasz.\nTym więcej skarbu uda ci się ocalić im silniej zaatakujesz.");
        System.out.println("Jesteś wyposażony w: "+hero.getEquipment().getName());
        System.out.println("Atak: "+hero.getEquipment().getAttack()+"pkt");
        System.out.println("Obrona: "+hero.getEquipment().getProtection()+"pkt");
        System.out.println();
        Random random=new Random();
        int hurt=Math.abs(random.nextInt()) % (500/hero.getEquipment().getProtection());
        int prize=Math.abs(random.nextInt()) % (4*hero.getEquipment().getAttack());
        if(hurt>hero.getHp()){
            nextLocation=new Exit(hero);
            System.out.println("Piraci okazali się silniejsi od twojej załogi\nKodeks piracki jest okrutny. Twoją załągę czeka zguba.");
        } else {
            System.out.println("Twojej załodze udało się pokonać piratów.\nWalka była ciężka, a w jej efekcie utraciłeś "+hurt+"punktów życia.\n" +
                    "W wyniku wygrania walki zdobywasz "+prize+" sztuk złota\nbędących łupem pirackim.");
            hero.setHp(hero.getHp()-hurt);
            hero.setMoney(hero.getMoney()+prize);
            System.out.println("Pozostałe życie: "+hero.getHp()+"pkt");
            System.out.println("Stan złota: "+hero.getMoney()+"pkt");
            System.out.println("Zwycięztwo pozwala ci samemu zadecydować o dalszym celu podróży:");
            Scanner scanner=new Scanner(System.in);
            List<LocationEnum> locations= LocationEnum.getLocations();
            for(int i=0; i<locations.size(); i++)
                System.out.println("["+(i+1)+"."+locations.get(i).getName()+"]");
            int decision=scanner.nextInt();
            nextLocation=locations.get(decision-1).getLocation();
            nextLocation.setHero(hero);
        }
    }

}
