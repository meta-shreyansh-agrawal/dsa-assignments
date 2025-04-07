package Session3.Question3;

import Question3.IdObject;

public class Bowler extends IdObject implements Comparable<Bowler> {
    final private String name; 
    private int balls; 

    Bowler(String name, int balls){
        this.name = name; 
        this.balls = balls; 
    }

    public int getBalls(){
        return this.balls; 
    }

    public void decrementBalls(){
        this.balls--; 
    }

    public String getName(){
        return this.name; 
    }

    // Comparision basis is Descending order based on balls
    @Override
    public int compareTo(Bowler other) {
        return Integer.compare(other.balls, this.balls);  
    }
}
