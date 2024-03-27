package parcial1_2018_19;

import acm.program.CommandLineProgram;
import acm.util.RandomGenerator;

public class Problema1 extends CommandLineProgram {

    private static final int numToSearch = 7;
    public void run() {

        NonEmptyIntervalSet set = new NonEmptyIntervalSet();

        for (int i = 0; i < 20; i++) {
            int min = gen();
            int max = gen();

            if(set.addInterval(min, max)) println("Creado con éxito!!");
        }
        println(set.toString());
        int num = numToSearch;
        println("Cantidad de veces que sale \""+ num+"\": "+set.numContains(num));
    }

    public int gen(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(-20, 20);
    }

    public static void main(String[] args) {
        new Problema1().start(args);
    }

}
