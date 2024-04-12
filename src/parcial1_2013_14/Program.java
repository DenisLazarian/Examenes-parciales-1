package parcial1_2013_14;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class Program extends CommandLineProgram {

    public void run() {
        String c = "1#3 2#4 3#5 4#4 6#7";
        TextHistogram t = new TextHistogram('*', 8);
        processHistogram(c, t);

        println(t.toString());
    }

    private void processHistogram(String c, TextHistogram t) {
        StringTokenizer tk = new StringTokenizer(c, " ");

        while (tk.hasMoreTokens()){
            String token = tk.nextToken();

            int category = Integer.parseInt(String.valueOf(token.charAt(0)));
            int times = Integer.parseInt(String.valueOf(token.charAt(2)));

            for (int i = 0; i < times; i++) {
                t.observed(category);
            }

        }


    }

    public static void main(String[] args) {
        new Program().start(args);
    }


}
