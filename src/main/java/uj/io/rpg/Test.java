package uj.io.rpg;

import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Desert;
import uj.io.rpg.locations.Location;

public class Test {
    public static void main(String[] args) {
        Hero hero=new Hero();
        Location location=new Desert(hero);
        System.out.println(location.getClass());
        if(location.getClass()==Desert.class)
            System.out.println("OK");
    }
}
