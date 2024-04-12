package parcial1_2023_24;

import acm.util.RandomGenerator;


public class SecretNumber {
    private int n;
    private boolean discovered;
    private int guesses;

    public SecretNumber(){
        RandomGenerator rg = RandomGenerator.getInstance();
        n = rg.nextInt(1, 10);
        discovered = false;
    }

    public void guess(int number){
        if(!discovered){
            if(n != number){
                guesses += 1;
            }else{
                discovered = true;
            }
        }
    }

    public boolean isDiscovered(){
        return discovered;
    }

    public int numGuesses(){
        return guesses;
    }

    public String toString(){
        String s = "";


        s = s.concat("n = "+n);
        s = s.concat("\tdiscovered = "+discovered);

        return s;
    }

}
