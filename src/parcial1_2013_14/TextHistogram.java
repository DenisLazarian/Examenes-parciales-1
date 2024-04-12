package parcial1_2013_14;

public class TextHistogram {

    private char symbol;
    private int numCategories;
    private int[] obs;

    public TextHistogram(char symbol, int numCategories){
        obs = new int[numCategories];
        this.symbol = symbol;
        this.numCategories = numCategories;
    }

    public void observed(int category){
        if(category >= 1 && category <= this.numCategories){
            obs[category-1] += 1;
        }
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < obs.length; i++) {
            String cat = "";
            for (int j = 0; j < obs[i]; j++) {
                cat += symbol ;
            }
            cat = cat.concat(" ("+(i+1)+")\n");
            s = s.concat(cat);
        }

        return s;
    }


}
