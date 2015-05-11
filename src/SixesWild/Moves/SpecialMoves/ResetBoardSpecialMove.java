package SixesWild.Moves.SpecialMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Tile;
import SixesWild.Moves.ISpecialMove;
import SixesWild.Utilities;
import SixesWild.Views.Application;

import java.util.Random;
import java.util.Stack;

public class ResetBoardSpecialMove implements ISpecialMove {


    Grid grid;
    Level level;

    public ResetBoardSpecialMove(Grid grid, Level level) {
        this.grid = grid;
        this.level = level;
    }

    @Override
    public boolean isValid() {
        boolean validation = false;
        if (!level.hasWon()) {
            validation = true;
        }

        return validation;
    }

    @Override
    public boolean doMove(Application app) {

        if (isValid()) {
            Stack<Tile> tiles = new Stack<Tile>();
            for (int row = 0; row < Grid.MAX_ROWS; row++) {
                for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                    if (grid.getSquares()[row][column] != null
                            && grid.getSquares()[row][column].getTile() != null && (
                            !grid.getSquares()[row][column].isContainer()
                                    || (grid.getSquares()[row][column].isContainer()
                                    && grid.getSquares()[row][column].getTile().getNumber().getValue() != Utilities.SIX))) {
                        tiles.push(grid.getSquares()[row][column].getTile());
                        grid.getSquares()[row][column].setTile(null);
                    }
                }
            }

            Random random = new Random();

            for (int row = 0; row < Grid.MAX_ROWS; row++) {
                for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                    if (grid.getSquares()[row][column] != null
                            && grid.getSquares()[row][column].getTile() == null) {
                        if (tiles.size() > 0) {
                            int tileIndex = random.nextInt(tiles.size());
                            grid.getSquares()[row][column].setTile(tiles.get(tileIndex));
                            tiles.remove(tileIndex);

                            app.getGameScreen().getGridView().getSquareViews()[row][column].repaint();
                        } else {
                            break;
                        }
                    }
                }
            }

            app.getGameScreen().getResetBoardSpecialMoveSound().play();

            return true;
        }

        return false;
    }
}