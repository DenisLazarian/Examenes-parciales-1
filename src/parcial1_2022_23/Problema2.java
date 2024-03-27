package parcial1_2022_23;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class Problema2 extends CommandLineProgram {
    private static final int INITIAL_SIZE = 28;
    private WordStats stats;

    public void run() {
        this.stats = new WordStats(INITIAL_SIZE);
        System.out.println("hola");
        String text = readLine("Dime un texto:  ");
        countWord(text);
        showResult();
    }

    private void showResult() {
        String max = stats.max();
        if(max == null) println("No hi ha palabras. ");
        else println("La palabra mas repetida es: "+max);
    }

    private void countWord(String t){
        StringTokenizer tk = new StringTokenizer(t," +-;:.");

        while(tk.hasMoreTokens()){
            String token = tk.nextToken();
            countValid(token);  // Antes en esta función tenía puesto "countWord" igual le dio un lapsus al profe a la hora de escribir.
        }
    }

    private void countValid(String word){
        if(isValid(word)) this.stats.countWord(word);
    }

    public boolean isValid(String word){
        for (int i = 0; i < word.length(); i++) {
            if(Character.isDigit(word.charAt(i))) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
