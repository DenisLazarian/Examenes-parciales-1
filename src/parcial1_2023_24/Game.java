package parcial1_2023_24;

public class Game {
    
    private SecretNumber[] set;
    private int it;
    private int totalDiscovered;
    private int discovered;
    
    public Game(int initialSize){
        set = new SecretNumber[initialSize];
        totalDiscovered = 0;
        discovered = 0;

        for (int i = 0; i < initialSize; i++) {
            set[i] = new SecretNumber();
            it++;
        }
    }
    
    public void guess(int number){
        discovered = 0;
        for (int i = 0; i < it; i++) {
            set[i].guess(number);
            if(set[i].isDiscovered()) discovered++;
        }
        int y = 0;

        while(y<discovered){
            resize();
            set[it] = new SecretNumber();
            if(set[it].isDiscovered()) discovered++;
            it++;
            y++;
        }
        totalDiscovered += discovered;
    }

    private void addObject(int i, int n){
        set[i] = new SecretNumber();
        set[i].guess(n);
        if(set[i].isDiscovered()) discovered++;
        it++;
    }

    public int numGuessedOk(){
        return totalDiscovered;
    }

    private void resize() {
        if(it >= set.length){
            SecretNumber[] aux = set;
            set = new SecretNumber[aux.length * 2];

            for (int i = 0; i < aux.length; i++) {
                set[i] = aux[i];
            }
        }
    }

    public String toString(){
        String s = "";

        for (int i = 0; i < set.length; i++) {
            if(set[i] == null) s = s.concat("Obj "+i +" = null\n");
            else s = s.concat("Obj "+ i+ " = "+set[i].toString()+"\n");
        }
        s = s.concat("\nit = "+it+"\n");
        s = s.concat("totalDiscovered = "+totalDiscovered+"\n");

        return s;
    }


}
