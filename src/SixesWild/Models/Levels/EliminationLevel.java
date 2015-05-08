package SixesWild.Models.Levels;

import SixesWild.Models.*;

/**
 *
 */
public class EliminationLevel extends Level {

    int largestMarkable;
    Value numberNotMarked;

    public EliminationLevel(boolean unlockState) {
        super(unlockState);
        numberNotMarked = new Value(Grid.MAX_ROWS * Grid.MAX_COLUMNS);
    }

    public EliminationLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
    }

    public boolean hasWon() {
        return getNotMarked().getValue() == largestMarkable;
    }

    public Value getNotMarked() {

        int count = 0;
        for (int row = 0; row < Grid.MAX_ROWS; row++) {
            for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                if (grid.getSquares()[row][column] !=null && !grid.getSquares()[row][column].isMarked()) {
                    count++;
                }
            }
        }

        numberNotMarked.setValue(count);

        return numberNotMarked;
    }

}