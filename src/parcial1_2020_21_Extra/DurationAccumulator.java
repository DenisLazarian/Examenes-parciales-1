package parcial1_2020_21_Extra;

public class DurationAccumulator {

    Duration[] set;
    int marginSize;
    public DurationAccumulator(int initialSize, int marginSize){
        set = new Duration[initialSize];
        this.marginSize = (marginSize == 0) ? 1 : marginSize; // si marginSize es 0 no seria valido.
    }

    public boolean storeDuration(int id, Duration duration){
        if(id < 0 ||duration == null) return false;

        if(set.length > id && set[id] != null)
            set[id].add(duration);
        else{
            resize(id);
            set[id] = new Duration(duration.getHours(), duration.getMinutes(), duration.getSeconds());
        }
        return true;
    }

    public Duration durationAt(int id){
        if(set.length <= id) return null;
        return set[id];
    }

    public int getMinimum(){
        int idMin = -1;
        int i = 0;
        while(i< set.length){
            if(set[i] != null && (idMin < 0 || set[idMin].inSeconds() > set[i].inSeconds())){
                idMin = i;
            }
            i++;
        }
        return idMin;
    }


    private void resize(int id) {
        if(id >= set.length){
            Duration[] aux = set;
            set = new Duration[id + marginSize];
            int i = 0;
            while(i < aux.length){
                if(aux[i] != null) set[i] = aux[i];
                i++;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        int i = 0;
        while(i < set.length){
            if(set[i] != null) s = s.concat("Id: "+i + " ----- " + set[i] + "\n");
            i++;
        }
        return s;
    }
}
