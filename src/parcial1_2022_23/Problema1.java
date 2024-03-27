package parcial1_2022_23;

import acm.program.CommandLineProgram;

public class Problema1 extends CommandLineProgram {


    public void run() {
        WordStats set = new WordStats();

        String[] s = {
                "Kebab",
                "Amarillo",
                "Relámpago",
                "Relámpago",
                "Rompe huesos",
                "Payaso",
                "hielo",
                "hielo",
                "hielo",
                "hielo",
                "Basketball",
                "futbol",
                "futbol"
        };

        for (int i = 0; i < s.length; i++) {
            if(set.countWord(s[i])) println("Añadiendo palabra a la colección");
        }

        println(set.toString());
    }

    public static void main(String[] args) {
        new Problema1().start(args);
    }
}
