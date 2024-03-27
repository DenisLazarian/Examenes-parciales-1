package parcial1_2014_15;

import acm.program.CommandLineProgram;
import acm.util.RandomGenerator;

public class Problema1 extends CommandLineProgram {

    private static final int NUM_PLAYERS = 6;
    private static final int MAX_CENTIMETRES_ADVANCE = 10;

    public void run() {

        DistanceAccumulator disAcc = new DistanceAccumulator(NUM_PLAYERS);

        for (int i = 0; i < 30; i++) {
            disAcc.hasAdvanced(gen(), genDistance());
        }
        println(disAcc.toString());
        for (int i = 0; i < NUM_PLAYERS; i++) {
            println("Player "+(i+1)+": "+(disAcc.totalCentimeters(i+1))+" cm");
        }

    }

    public int gen(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(1, NUM_PLAYERS);
    }

    public Distance genDistance(){
        RandomGenerator rgy = RandomGenerator.getInstance();
        RandomGenerator rgf = RandomGenerator.getInstance();
        RandomGenerator rgi = RandomGenerator.getInstance();

        return Distance.formatString(rgy.nextInt(0, MAX_CENTIMETRES_ADVANCE)+"y"+ rgf.nextInt(0, MAX_CENTIMETRES_ADVANCE)+"f"+rgi.nextInt(0, MAX_CENTIMETRES_ADVANCE)+"i");
    }

    public static void main(String[] args) {
        new Problema1().start(args);
    }

}
