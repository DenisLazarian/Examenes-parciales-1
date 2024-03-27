package parcial1_2022_23;

public class WordCounter {

    private String word;
    private int counter;

    public WordCounter(String word){
        this.word = word;
        counter = 1;
    }

    public int getCounter(){
        return counter;
    }

    public String getWord() {
        return word;
    }

    public void increment(){
        counter+=1;
    }
}
