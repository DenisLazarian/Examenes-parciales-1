package parcial1_2018_19;

import acm.program.CommandLineProgram;

import java.util.Arrays;

public class NonEmptyIntervalSet extends CommandLineProgram {

    private Interval[] set;
    private int it;

    public NonEmptyIntervalSet(){
        this(10);
    }

    public NonEmptyIntervalSet(int n){
        this.set = new Interval[n];
        this.it = 0;
    }

    public boolean addInterval(int min, int max){
        Interval in = new Interval(min, max);

        if(max <= min) return false;
        else if(isRep(in)) return false;

        updateSpace();
        set[it] = in;
        it++;
        return true;
    }

    private void updateSpace() {
        if(set.length <= it){
            Interval[] aux = set;
            set = new Interval[it*2];

            for (int i = 0; i < aux.length; i++) {
                set[i] = aux[i];
            }
        }
    }

    private boolean isRep(Interval in) {
        int i = 0;
        while(i < set.length && set[i] != null){
            if(this.set[i].isEqual(in)) return true;
            i++;
        }
        return false;
    }

    public int numContains(int elem){
        int n = 0, i = 0;
        while(i < set.length && set[i] != null){
            if(set[i].contains(elem)) n++;
            i++;
        }
        return n;
    }

    @Override
    public String toString() {
        int i = 0; String str = "";
        while(i < set.length && set[i] != null){
            str = str.concat(set[i] +"\n");
            i++;
        }
        return str;
    }
}
