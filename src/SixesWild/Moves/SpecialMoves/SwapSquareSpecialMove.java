package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Square;
import SixesWild.Models.Tile;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;

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