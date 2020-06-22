package uj.io.rpg;

import org.junit.jupiter.api.Test;
import uj.io.rpg.events.desert.Camel;
import uj.io.rpg.events.desert.Jeep;
import uj.io.rpg.events.mountains.Climbing;
import uj.io.rpg.events.mountains.Dancing;
import uj.io.rpg.events.mountains.Fire;
import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.*;

import static org.junit.jupiter.api.Assertions.*;

public class MountainsTests {

    @Test
    public void climbingTest(){
        Hero hero=new Hero();
        hero.setEquipment(Equipment.GUN);
        int heroHealth=hero.getHp();
        int heroMoney=hero.getMoney();
        Climbing climbing=new Climbing(hero);
        climbing.execute();
        Location location=climbing.getNextLocation();

        if(location.getClass()== Forest.class){
            assertEquals(heroHealth+30, hero.getHp());
            assertEquals(heroMoney, hero.getMoney());
        }
        if(location.getClass()== Mountains.class){
            assertTrue(heroHealth>hero.getHp());
            assertEquals(heroMoney, hero.getMoney());
        }
    }

    @Test
    public void dancingTest(){
        Hero hero=new Hero();
        hero.setMoney(0);
        Dancing dancing=new Dancing(hero);
        dancing.execute();
        Location location=dancing.getNextLocation();
        assertSame(location.getClass(), Shop.class);
    }

    @Test
    public void fireTest(){
        Hero hero=new Hero();
        int heroHealth=hero.getHp();
        int heroMoney=hero.getMoney();
        Fire fire=new Fire(hero);
        fire.execute();
        Location location=fire.getNextLocation();

        if(location.getClass()== Mountains.class){
            assertTrue(heroHealth>hero.getHp());
            assertEquals(heroMoney, hero.getMoney());
        }
        if(location.getClass()== Ocean.class){
            assertEquals(heroHealth, hero.getHp());
            assertEquals(heroMoney, hero.getMoney());
        }
    }

}
