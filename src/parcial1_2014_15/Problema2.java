package parcial1_2014_15;

import acm.program.CommandLineProgram;

import java.util.Objects;
import java.util.StringTokenizer;

public class Problema2 extends CommandLineProgram {

    private static final int NUM_PLAYERS = 20;

    public void run() {
        DistanceAccumulator da = new DistanceAccumulator(NUM_PLAYERS);
        println("Para parar el programa y mostrar los resultados pulse 0 y ENTER!");
        String d = readLine("Dame una distancia en formato j#xxyxxfxxi: ");

        // De esta forma el programa pedirá al usuario continuamente distancias.
        while(!d.equals("0")){
            StringTokenizer tk = new StringTokenizer(d, "#");

            int numPlayer = Integer.parseInt(tk.nextToken()); // guardo el número del jugador.
            Distance dist = Distance.formatString(tk.nextToken()); // formateo la distancia pasada en el formato xxyxxfxxi a objeto Distance
            da.hasAdvanced(numPlayer,dist); // Acumulo las distancias que van apareciendo

            d = readLine("Dame una distancia en formato j#xxyxxfxxi: ");
        }

        println(toStringCent(da));
    }

    // Devuelvo las distancias en caso de que el jugador ha avanzado, directamente en centímetros.
    public String toStringCent(DistanceAccumulator da){
        String r = "";

        for (int i = 0; i < NUM_PLAYERS; i++) {
            double nj = da.totalCentimeters(i+1);
            if(nj > 0) r = r.concat((i+1)+ " - " +(nj)+" cm")+"\n";
        }
        return r;
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
