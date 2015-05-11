package SixesWild.Models.Levels;

import SixesWild.Models.*;

/**
 *
 */
public class EliminationLevel extends Level {

    int largestMarkable;
    Value notMarked = new Value(0);

    public EliminationLevel(boolean unlockState) {
        super(unlockState);
        notMarked = new Value(Grid.MAX_ROWS * Grid.MAX_COLUMNS);
        largestMarkable = 0;
    }

    public EliminationLevel(boolean unlockState,
                            Value id,
                            Score score,
                            Grid grid,
                            SpecialMoveLeft specialMoveLeft,
                            Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
    }

    public boolean hasWon() {
        return getNotMarked().getValue() == largestMarkable;
    }

    public Value getNotMarked() {

        int count = 0;
        for (int row = 0; row < Grid.MAX_ROWS; row++) {
            for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                if (grid.getSquares()[row][column] != null && !grid.getSquares()[row][column].isMarked()) {
                    count++;
                }
            }
        }

        notMarked.setValue(count);

        return notMarked;
    }

}