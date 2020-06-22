package uj.io.rpg.locations;

import uj.io.rpg.hero.Hero;

import java.util.List;

public enum LocationEnum {

    DESERT("Pustynia", new Desert(null)),
    FOREST("Las", new Forest(null)),
    ISLAND("Wyspa", new Island(null)),
    MOUNTAINS("Góry", new Mountains(null)),
    OCEAN("Ocean", new Ocean(null)),
    SHOP("Sklep", new Shop(null));

    private final String name;
    private final Location location;
    LocationEnum(String name, Location location){
        this.name=name;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public static List<LocationEnum> getLocations(){
        return List.of(
                DESERT,
                FOREST,
                ISLAND,
                MOUNTAINS,
                OCEAN,
                SHOP
        );
    }
}
