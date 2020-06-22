package uj.io.rpg;

import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Island;
import uj.io.rpg.locations.Location;
import uj.io.rpg.locations.Shop;

public class Main {
    public static void main(String[] args) {

        Hero hero=new Hero();
        try{
            Location location=new Shop(hero);
            while(true){
                location.execute();
                location=location.nextLocation();
            }
        } catch (Exception e){
            Location location=new Island(hero);
            location.execute();
        }

    }
}
