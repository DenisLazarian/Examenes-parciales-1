package parcial1_2014_15;

import java.util.Arrays;

public class DistanceAccumulator {

    Distance[] set;
    public DistanceAccumulator(int numPlayers){
        this.set = new Distance[numPlayers];

        for (int i = 0; i < set.length; i++) {
            set[i] = new Distance();
        }
    }

    public void hasAdvanced(int player, Distance distance){
        int numPlayerOnArray = player-1;
        if(validPlayer(player)) set[numPlayerOnArray].add(distance);
    }

    private boolean validPlayer(int player){
        return (player-1 >= 0 && set.length > player-1);
    }

    public double totalCentimeters(int player){
        if(!validPlayer(player)) return -1.0;
        return set[player-1].toInches() * 2.54;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < set.length; i++) s = s.concat(set[i].toString());
        return s;
    }
}
