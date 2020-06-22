package uj.io.rpg;

import org.junit.jupiter.api.Test;
import uj.io.rpg.events.forest.Mushrooms;
import uj.io.rpg.hero.Hero;

import static org.junit.jupiter.api.Assertions.*;

public class ForestTests {

    @Test
    public void mushroomTest(){
        Hero hero=new Hero();
        int heroHealth=hero.getHp();
        Mushrooms mushrooms=new Mushrooms(hero);
        mushrooms.execute();
        assertNotEquals(heroHealth, hero.getHp());
    }

}
