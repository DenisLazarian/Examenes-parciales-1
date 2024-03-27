package parcial1_2022_23;

import java.util.Arrays;

public class WordStats {
    WordCounter[] set;
    private int nw;

    public WordStats(){
        this(10);
    }

    public WordStats(int initialSize) {
        this.set = new WordCounter[initialSize];
    }

//    public boolean countWord(String word){
//        int cw = 0;
//        boolean found = false;
//
//        while(cw < set.length && set[cw] != null){
//             if(set[cw].getWord().equals(word)){
//                 found = true;
//                 set[cw].increment();
//             }
//             cw++;
//        }
//        if(!found){
//            if(nw >= set.length) resize();
//            set[nw] = new WordCounter(word);
//            nw += 1;
//            return true;
//        }
//        return false;
//    }

    // Solución del profe.
    public boolean countWord(String word){
        int pos = findWord(word);
        if(pos < 0){
            if(this.nw == this.set.length){
                resize();
            }
            this.set[nw] = new WordCounter(word);
            nw += 1;
            return true;
        }else{
            this.set[pos].increment();
            return false;
        }
    }

    private int findWord(String word) {
        for (int i = 0; i < nw; i++) {
            if(set[i].getWord().equals(word)){
                return i;
            }
        }
        return -1;
    }


    private void resize(){
        WordCounter[] aux = set;
        set = new WordCounter[nw*2];

        for (int i = 0; i < aux.length; i++) {
            set[i] = aux[i];
        }
    }

    private int getCounter(String word){
        int it = findWord(word);
        if(it < 0) return 0;
        return set[it].getCounter();
    }

    public String max(){
        if(nw == 0) return null;

        WordCounter wordMx = this.set[0];
        for (int i = 0; i < nw; i++) {
            if(wordMx.getCounter() < this.set[i].getCounter()) {
                wordMx = this.set[i];
            }
        }
        return wordMx.getWord();
    }

    @Override
    public String toString() {
        String r = "";

        for (int i = 0; i < nw; i++) {
            r = r.concat("Word: "+set[i].getWord()+" --- Counter: "+set[i].getCounter()+"\n");
        }
        return r;
    }
}
