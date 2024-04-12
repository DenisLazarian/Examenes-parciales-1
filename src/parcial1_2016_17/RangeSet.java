package parcial1_2016_17;

import org.w3c.dom.ranges.Range;

public class RangeSet {
    private int min;
    private int max;
    private int[] interval;
    private boolean zeroAdded;

    public RangeSet(int min, int max){
        interval = new int[max-min];
        this.min = min;
        this.max = max;
        zeroAdded = false;
    }

    boolean add(int elem){
        if(isOutOfBound(elem)) return false;

        if(elem == 0) zeroAdded = true;

        interval[elem - min] = elem;
        return true;
    }

    boolean contains(int elem){
        return !isOutOfBound(elem) && interval[elem - min] != 0;
    }

    private boolean includeZero(){ // ya tengo garantizado que max siempre es mayor o igual a min.
        return min>0 || max<0;
    }

    public static RangeSet union(RangeSet rs1, RangeSet rs2){
        int min = Math.min(rs1.min, rs2.min);
        int max = Math.max(rs1.max, rs2.max);

        RangeSet result = new RangeSet(min, max);

        for (int i = min; i < max; i++) {
            if(rs1.contains(i)) {
                result.add(i);
            } else if (rs2.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public int size(){
        int c = 0;
        for (int i = 0; i < interval.length; i++) {
            if (this.contains(i)) c++;
        }
        if(includeZero() && zeroAdded) c++; // si el conjunto incluye un espacio para 0 y además lo hemos añadido, aumentamos en 1.
        return c;
    }

    private boolean isOutOfBound(int elem){
        return elem >= max || elem < min;
    }

    public static RangeSet unionAll(RangeSet[] set){
        RangeSet result = set[0];
        for (int i = 1; i < set.length; i++) {
            result = RangeSet.union(result, set[i]);
        }
        return result;
    }

}
