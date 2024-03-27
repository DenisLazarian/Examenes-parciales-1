package parcial1_2014_15;

import java.util.StringTokenizer;

public class Distance {

    private int yard;
    private int feet;
    private int inches;


    public static Distance formatString(String yfi){
        StringTokenizer tk = new StringTokenizer(yfi,"yfi");
        Distance d = new Distance();

        int y = Integer.parseInt(tk.nextToken());
        int f = Integer.parseInt(tk.nextToken());
        int i = Integer.parseInt(tk.nextToken());

        if(y < 0 || f < 0 || i < 0) return null;

        d.yard = y;
        d.feet = f;
        d.inches = i;

        return d;
    }

    public Distance(){
        this.yard = 0;
        this.feet = 0;
        this.inches = 0;
    }


    public void add(Distance other){
        this.yard += other.yard;
        this.feet += other.feet;
        this.inches += other.inches;
    }

    public int toInches(){
        return this.inches + ((this.yard * 3 + this.feet) * 12);
    }

    public String toString(){
//        return "Distance: "+ " Yards: "+yard+" --- Feet: "+ feet + " --- Inches: "+ inches + "\n";
        return yard+"y"+feet+"f"+inches+"i\n";
    }

}
