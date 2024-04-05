package parcial1_2021_22;

public class CharPair {

    private final char from;
    private final char to;

    public CharPair(char from, char to){
        this.from = from;
        this.to = to;
    }

    public int encode(char c){
        if(from == c) return to;
        return -1;
    }

    public boolean conflictsWith(CharPair other){
        return this.from == other.from || this.to == other.to;
    }

    public CharPair invert(){
        return new CharPair(to, from);
    }

    @Override
    public String toString() {
        return  "|" + from + " ------- "+
                 to + "|" +
                '\n';
    }
}
