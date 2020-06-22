package uj.io.rpg;

import org.junit.jupiter.api.Test;
import uj.io.rpg.events.desert.Camel;
import uj.io.rpg.events.desert.Jeep;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.*;

import static org.junit.jupiter.api.Assertions.*;

public class DesertTests{

    @Test
    public void jeepExitTest(){
        Hero hero=new Hero();
        hero.setMoney(0);
        Jeep jeep=new Jeep(hero);
        jeep.execute();
        Location location=jeep.getNextLocation();
        assertSame(location.getClass(), Exit.class);
    }

    @Test
    public void jeepMountainsTest(){
        Hero hero=new Hero();
        hero.setMoney(1000000000);
        Jeep jeep=new Jeep(hero);
        jeep.execute();
        Location location=jeep.getNextLocation();
        assertSame(location.getClass(), Mountains.class);
    }

    @Test
    public void camelTest(){
        Hero hero=new Hero();
        int heroHealth=hero.getHp();
        int heroMoney=hero.getMoney();
        Camel camel=new Camel(hero);
        camel.execute();
        Location location=camel.getNextLocation();
        if(location.getClass()== Forest.class){
            assertTrue(heroMoney<hero.getMoney());
            assertEquals(heroHealth, hero.getHp());
        }
        if(location.getClass()== Desert.class){
            assertTrue(heroHealth>hero.getHp());
            assertEquals(heroMoney, hero.getMoney());
        }
    }

}
