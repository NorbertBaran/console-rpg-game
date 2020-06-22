package uj.io.rpg.events.forest;

import uj.io.rpg.events.Event;
import uj.io.rpg.hero.Hero;
import uj.io.rpg.locations.Mountains;

import java.util.Random;
import java.util.Scanner;

public class River extends Event {

    public River(Hero hero){
        super(hero);
        this.eventName="Rzeka";
    }

    @Override
    public void execute() {
        System.out.println("Decydujesz się pójść wzdłóż rzeki. Podczas podróży natrafiasz na\nserię rozwidleń decydujących o tym jak męcząca będzie twoja wyprawa.");
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int[] shorterPath=new int[5];
        for(int i=0; i<5; i++)
            shorterPath[i]=Math.abs(random.nextInt()) % 2 + 1;
        int tiredness=15;
        for(int i=0; i<5; i++){
            System.out.println("Rozwidlenie "+(i+1)+". Wybierz sronę, w którą chcesz skręcić:\n[1.Prawo]\n[2.Lewo]");
            int choose=scanner.nextInt();
            if(choose==shorterPath[i])
                tiredness-=5;
            else
                tiredness+=5;
        }
        if(tiredness<=0)
            System.out.println("Gratulacje!!! Udało ci się pokonać drogę wystarczająco\nszybko aby nie stracić energii.");
        else{
            System.out.println("Droga wzdłóż rzeki okazała się męcząca.\nTracisz "+tiredness+" punktów życia");
            hero.setHp(hero.getHp()-tiredness);
            System.out.println("Posiadasz: "+hero.getHp()+"pkt życia");
        }
        nextLocation=new Mountains(hero);

    }

}
