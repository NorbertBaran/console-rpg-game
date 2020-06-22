package uj.io.rpg;

import org.junit.jupiter.api.Test;
import uj.io.rpg.events.island.Suicide;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Exit;
import uj.io.rpg.locations.Location;

import static org.junit.jupiter.api.Assertions.*;

public class IslandTests {

    @Test
    public void suicideTest(){
        Hero hero=new Hero();
        Suicide suicide=new Suicide(hero);
        suicide.execute();
        Location location=suicide.getNextLocation();
        assertEquals(location.getClass(), Exit.class);
    }

}
