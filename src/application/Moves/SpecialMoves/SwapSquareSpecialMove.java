package application.Moves.SpecialMoves;

import application.Models.Grid;
import application.Models.Levels.Level;
import application.Models.Square;
import application.Models.Tile;
import application.Moves.ISpecialMove;
import application.Views.Application;

/**
 *
 */
public class SwapSquareSpecialMove implements ISpecialMove {

    Grid grid;
    Level level;

    public SwapSquareSpecialMove(Grid grid, Level level) {
        this.grid = grid;
        this.level = level;
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        if (!level.hasWon() && grid.getActiveSquare().size() == 2) {
            validation = true;
        }
        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if (isValid()) {

            Square firstSquare = grid.getActiveSquare().get(0);
            Square secondSquare = grid.getActiveSquare().get(1);

            Tile tmpTile = firstSquare.getTile();
            firstSquare.setTile(secondSquare.getTile());
            secondSquare.setTile(tmpTile);

            app.getGameScreen().getGridView().getActiveSquareViews().get(0).repaint();
            app.getGameScreen().getGridView().getActiveSquareViews().get(1).repaint();

            app.getGameScreen().getSwapSquaresSpecialMoveSound().play();

            return true;
        }

        return false;
    }
}