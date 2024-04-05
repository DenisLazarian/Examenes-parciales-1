package parcial1_2017_18;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class Problema2 extends CommandLineProgram {

    private int ERROR = 0;

    @Override
    public void run() {
//        String sx = readLine("Dame números x: ");
//        String sy = readLine("Dame números y: ");

        String sx = "1.0 2.0";
        String sy = "3.0 9.0 12.5 4.7";

        StringTokenizer tkx = new StringTokenizer(sx, " ");
        StringTokenizer tky = new StringTokenizer(sy, " ");

        Covariance cov = new Covariance();

        int c = Math.max(tkx.countTokens(), tky.countTokens());
        int i = 0;
        while(i < c){
            if(tkx.hasMoreTokens() && tky.hasMoreTokens()){
                cov.addPair(
                        Double.parseDouble(tkx.nextToken()),
                        Double.parseDouble(tky.nextToken())
                );

            }else ERROR++;
            i++;
        }
        double covT = cov.covarianceXY();

        println("La covariancia es "+covT);
        println("Hay "+ ERROR+ " elementos desparejadors.");
    }

    public static void main(String[] args) {
        new Problema2().start(args);
    }
}
