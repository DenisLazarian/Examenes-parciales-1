package parcial1_2018_19;

public class Interval {

    private int min;
    private int max;

    public Interval(int min, int max){
        this.min = min;
        this.max = max;
    }

    public boolean contains(int elem){
        return !(elem > max || elem < min);
    }

    public boolean isEqual(Interval other){
        return (max == other.max && min == other.min);
    }

    public String toString() {
        return "min=" + min +
                ", max=" + max;
    }
}
