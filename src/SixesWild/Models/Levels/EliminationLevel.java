package SixesWild.Models.Levels;

import SixesWild.Models.*;

/**
 *
 */
public class EliminationLevel extends Level {

    int largestMarkable;

    public EliminationLevel(boolean unlockState) {
        super(unlockState);
        largestMarkable = grid.getLargestMarkable();
    }

    public EliminationLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
    }

    public boolean hasWon() {
        return getNotMarked().getValue() == largestMarkable;
    }

    public Value getNotMarked() {
        return grid.getNotMakred();
    }

}