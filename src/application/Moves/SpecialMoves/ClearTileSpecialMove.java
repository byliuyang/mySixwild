package application.Moves.SpecialMoves;

import application.Models.Grid;
import application.Models.Levels.Level;
import application.Moves.ISpecialMove;
import application.Views.Application;
import application.Views.Components.SpecialMoveNavigationBar;

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