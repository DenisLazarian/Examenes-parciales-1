package parcial1_2020_21;

public class Duration {

    private int hours;
    private int minutes;
    private int seconds;

    public Duration(int hours, int minutes,int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        normalize();
    }

    private void normalize(){
        minutes += seconds / 60;
        seconds = seconds % 60;

        hours += minutes / 60;
        minutes = minutes % 60;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int inSeconds(){
        return hours * 3600 + minutes * 60 + seconds;
    }

    public void add(Duration other){
        if(other != null){
            hours += other.hours;
            minutes += other.minutes;
            seconds += other.seconds;
            normalize();
        }
    }

    @Override
    public String toString() {
        return hours + "h : "+ minutes+"m : "+ seconds + "s ";
    }

    public static Duration add(Duration d1, Duration d2){
        if(d1 == null || d2 == null) return null;

        return new Duration(
                d1.hours + d2.hours,
                d1.minutes + d2.minutes,
                d1.seconds + d2.seconds
        );
    }
}
