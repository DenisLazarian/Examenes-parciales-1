package parcial1_2016_17;

import acm.program.CommandLineProgram;
import acm.program.ConsoleProgram;

import java.util.StringTokenizer;

public class Pokedex extends CommandLineProgram {

    RangeSet[] generations = new RangeSet[7];

    public void run() {
        addGenerations();
        String pokemonData = "2#12 5#6 2#7 2#12 3#4 5#6 3#2 1#12 6#4";
//        String pokemonData = readLine("List of tokens: ");
        processSets(pokemonData);
        showResults();
    }

    private void showResults() {
        String s = "";
        for (int i = 0; i < generations.length; i++) {
            int np = generations[i].size();
            if(np>0) s = s.concat("Generation "+ i+ ": "+ np + "\n");
        }

        RangeSet ru = RangeSet.unionAll(generations);
        s = s.concat("Dorsales diferentes: "+ ru.size());
        println(s);
    }

    private void processSets(String p) {
        StringTokenizer tk = new StringTokenizer(p, " ");
        while(tk.hasMoreTokens()){
            String item = tk.nextToken();
            StringTokenizer tk2 = new StringTokenizer(item, "#");

            while(tk2.hasMoreTokens()){
                int generation = Integer.parseInt(tk2.nextToken());
                int pokemon = Integer.parseInt(tk2.nextToken());
                generations[generation].add(pokemon);
            }
        }
    }

    private void addGenerations(){
        for (int i = 0; i < generations.length; i++) {
            generations[i] = new RangeSet(1,100);
        }
    }

    public static void main(String[] args) {
        new Pokedex().start(args);
    }
}
