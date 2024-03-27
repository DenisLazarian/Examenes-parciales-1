package parcial1_2020_21;

import acm.program.CommandLineProgram;

import java.util.Objects;
import java.util.StringTokenizer;

public class Problema2 extends CommandLineProgram {

    public void run() {
        DurationAccumulator da = new DurationAccumulator(5, 3);

        String s = readLine("Dame una duración: ");

        while(!Objects.equals(s, "0")){ // tiene más sentido el programa si pregunto más duraciones para comparar.
            StringTokenizer st = new StringTokenizer(s, " #");

            int id = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            if(hour >= 0 && min >= 0 && sec >= 0){
                Duration d = new Duration(hour, min, sec);
                da.storeDuration(id, d);
            }else println("Error!!");
            s = readLine("Dame una duración: ");
        }

        int idMin = da.getMinimum();
        if(idMin >= 0) println("Minimum value id: "+idMin);
        else println("It is not exist.");
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
