package application.Models.Levels;

import application.Models.*;

/**
 *
 */
public class LightningLevel extends Level {

    Time time;

    public LightningLevel(boolean unlockState) {
        super(unlockState);
    }

    public LightningLevel(boolean unlockState,
                          Value id,
                          Score score,
                          Grid grid,
                          SpecialMoveLeft specialMoveLeft,
                          Probabilities probabilities,
                          Time time) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
        this.time = time;
    }

    public boolean hasWon() {
        return time.isUsedUp();
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}