package parcial1_2023_24;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class GuessProgram extends CommandLineProgram {
    private static final int INITIAL_SIZE = 10;
    private Game game;

    public void run(){
        this.game = new Game(INITIAL_SIZE);
        processGuesses();
        showResults();
        println(game.toString());
    }

    private void showResults() {
        println("La cantidad de numeros adivinados son:" + game.numGuessedOk());
    }

    private void processGuesses() {
        String s = readLine("Dime numeros: ");
        StringTokenizer st = new StringTokenizer(s, " ");

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            this.game.guess(n);
        }
    }

    public static void main(String[] args) {
        new GuessProgram().start(args);
    }


}
