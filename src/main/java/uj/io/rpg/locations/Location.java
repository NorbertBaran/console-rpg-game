package uj.io.rpg.locations;

import uj.io.rpg.Main;
import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public abstract class Location {

    protected Location nextLocation;
    protected List<Event> events;
    protected Hero hero;
    protected Scanner scanner;

    public Location(Hero hero){
        this.hero=hero;
        this.scanner=new Scanner(System.in);
    }

    public void setHero(Hero hero) {
        this.hero = hero;
        for (Event event:events)
            event.setHero(hero);
    }

    protected void printDescription(String path){
        try{

            System.out.println(
                    Files.readString(
                            Path.of(
                                    Main.class.getResource(path).getPath()
                            )
                    )
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void printEvents(List<Event> events){
        int counter=1;
        for(Event event: events){
            System.out.println("["+counter+"."+event.getEventName()+"]");
            counter++;
        }
    }

    protected void makeEvent(int event){
        events.get(event).execute();
        nextLocation=events.get(event).getNextLocation();
    }

    public abstract void execute();

    public Location nextLocation(){
        return nextLocation;
    }
}
