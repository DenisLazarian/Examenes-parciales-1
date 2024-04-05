package parcial1_2021_22;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class CypherProgram extends CommandLineProgram {

    private static final int INITIAL_SIZE = 28;
    private Cypher cypher;
    private int numErrors;
    private void initializeResults() {
        this.cypher = new Cypher(INITIAL_SIZE);
        this.numErrors = 0;
    }
    public void run() {
        this.initializeResults();
//        String claves = readLine("Dame las claves: ");
//        String frase = readLine("Dime una frase: ");
        String claves = "a>b b>z b>u i>z p>o r>t t>z t>c v>f";
        String frase = "patata brava";

        StringTokenizer st = new StringTokenizer(claves, " ");

//        cypher.addPair(' ', ' ');
        while(st.hasMoreTokens()){
            String clave = st.nextToken();
            if(!cypher.addPair(clave.charAt(0), clave.charAt(2))) numErrors++;
        }

        String cod = this.cypher.encode(frase);

        println(cypher.toString());
        if(cod != null){
            println("Errores: "+numErrors);
            println("Cifrado: "+cod);
        }else println("No se ha podido codificar.");
    }

    public static void main(String[] args) {
        new CypherProgram().start(args);
    }


}
