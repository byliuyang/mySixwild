package application.Models;

import java.io.Serializable;

/**
 *
 */
public class Score implements Serializable {

    Value currentScore;

    Value oneStarScore;
    Value twoStarScore;
    Value threeStarScore;

    public Score(Value oneStarScore, Value twoStarScore, Value threeStarScore) {
        this.oneStarScore = oneStarScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;

        this.currentScore = new Value(0);
    }

    public Value getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(long currentScore) {
        this.currentScore.setValue(currentScore);
    }

    public Value getOneStarScore() {
        return oneStarScore;
    }

    public void setOneStarScore(Value oneStarScore) {
        this.oneStarScore = oneStarScore;
    }

    public Value getTwoStarScore() {
        return twoStarScore;
    }

    public void setTwoStarScore(Value twoStarScore) {
        this.twoStarScore = twoStarScore;
    }

    public Value getThreeStarScore() {
        return threeStarScore;
    }

    public void setThreeStarScore(Value threeStarScore) {
        this.threeStarScore = threeStarScore;
    }

    public int getStarNumber(){
        if(currentScore.getValue()>=threeStarScore.getValue()) {
            return 3;
        } else if(currentScore.getValue()>=twoStarScore.getValue()){
            return 2;
        } else if(currentScore.getValue()>=oneStarScore.getValue()){
            return 1;
        } else {
            return 0;
        }
    }
}