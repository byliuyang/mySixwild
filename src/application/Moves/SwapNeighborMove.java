package application.Moves;

import application.Models.BonusMultiplier;
import application.Models.Grid;
import application.Models.Levels.EliminationLevel;
import application.Models.Levels.Level;
import application.Models.Square;
import application.Models.Value;
import application.Utilities;
import application.Views.Application;

import java.util.ArrayList;

/**
 *
 */
public class SwapNeighborMove implements IMove {

    final int BASE_SCORE = 10;

    Grid grid;
    Level level;

    public SwapNeighborMove(Grid grid, Level level) {
        this.grid = grid;
        this.level = level;
    }

    @Override
    public boolean isValid() {
        boolean validation = true;

        if (level.hasWon()) {
            validation = false;
        }

        Value count = new Value(0);

        ArrayList<Square> activeSquares = grid.getActiveSquare();
        int numberActived = activeSquares.size();
        if (numberActived > 0) {
            for (int i = 0; i < numberActived - 1; i++) {
                Square currentSquare = activeSquares.get(i);
                Square nextSquare = activeSquares.get(i + 1);

                if (!currentSquare.isAdjacent(nextSquare)) {
                    validation = false;
                } else {
                    count.increase(currentSquare.getTile().getNumber().getValue());
                }
            }

            count.increase(activeSquares.get(numberActived - 1).getTile().getNumber().getValue());
            if (count.getValue() != Utilities.SIX) {
                validation = false;
            } else if (numberActived == 1) {
                validation = false;
            }
        }

        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if (isValid()) {
            Value count = new Value(0);
            ArrayList<Square> activeSquares = grid.getActiveSquare();
            int numberActived = activeSquares.size();

            count.increase(BASE_SCORE * numberActived);

            for (int i = 0; i < numberActived; i++) {
                BonusMultiplier multiplier = activeSquares.get(i).getTile().getMutiplier();
                if (multiplier != null) {
                    count.multiply(activeSquares.get(i).getTile().getMutiplier().getMultiplier().getValue());
                    grid.getActiveSquare().get(i).setTile(null);

                    if (level instanceof EliminationLevel) {
                        grid.getActiveSquare().get(i).mark();
                        app.getGameScreen().getGridView().getActiveSquareViews().get(i).repaint();
                    }
                }
            }

            if (level instanceof EliminationLevel) {
                ((EliminationLevel) level).getNotMarked();
            }

            app.getGameScreen().getTileDisappearSound().play();

            app.getGameScreen().updateScore(count);

            return true;

        } else {
            return false;
        }
    }
}