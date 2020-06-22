package uj.io.rpg;

import org.junit.jupiter.api.Test;
import uj.io.rpg.events.ocean.Fight;
import uj.io.rpg.hero.Equipment;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Location;

import static org.junit.jupiter.api.Assertions.*;

public class OceanTests {

    @Test
    public void fightTest(){
        Hero hero=new Hero();
        hero.setHp(10);
        hero.setEquipment(Equipment.NOTHING);
        Fight fight=new Fight(hero);
        fight.execute();
        Location location=fight.getNextLocation();
        assertSame(location.getClass(), Exit.class);
    }

}
