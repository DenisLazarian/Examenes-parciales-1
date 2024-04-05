package parcial1_2020_21_Extra;

import acm.program.CommandLineProgram;
import acm.util.RandomGenerator;

public class Problema1 extends CommandLineProgram {

    public void run() {
        DurationAccumulator da = new DurationAccumulator(7, 6);
        for (int i = 0; i < 20; i++) {
            Duration d = new Duration(raH(), ranSecMin(), ranSecMin());
            da.storeDuration(ran(), d);
        }

        println(da.toString());
        println();
        int idMin = da.getMinimum();
        println("Mínimo id: "+idMin+" Valor: "+ da.durationAt(idMin).toString());
    }

    public int ran(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(0, 20);
    }

    public int raH(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(0, 3);
    }

    public int ranSecMin(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(0, 100);
    }

    public static void main(String[] args) {
        new Problema1().start(args);
    }
}
