package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Views.Application;
import SixesWild.Views.Components.SpecialMoveNavigationBar;

/**
 *
 */
public class ClearTileSpecialMove implements ISpecialMove {

    Grid grid;
    Level level;

    public ClearTileSpecialMove(Grid grid, Level level) {
        this.grid = grid;
        this.level = level;
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        if ((!level.hasWon()) && grid.getActiveSquare().size() > 0 && grid.getActiveSquare().get(0).getTile() != null) {
            validation = true;
        }

        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if (isValid()) {
            grid.getActiveSquare().get(0).setTile(null);
            ((SpecialMoveNavigationBar) app.getGameScreen().getNavigationBar()).modelChanged();

            app.getGameScreen().getRemoveTileSpecialMoveSound().play();

            return true;
        } else {
            return false;
        }
    }
}