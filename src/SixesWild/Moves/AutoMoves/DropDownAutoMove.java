package SixesWild.Moves.AutoMoves;

import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Levels.ReleaseLevel;
import SixesWild.Models.Square;
import SixesWild.Moves.IMove;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.GameScreenPackage.SquareView;

import java.util.*;

/**
 * Created by harryliu on 5/6/15.
 */
public class DropDownAutoMove implements IMove {

    Level level;
    Grid grid;

    public DropDownAutoMove(Level level, Grid grid) {
        this.level = level;
        this.grid = grid;
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
            Square[][] squares = app.getGameScreen().getGridView().getGrid().getSquares();
            SquareView[][] squareViews = app.getGameScreen().getGridView().getSquareViews();

            for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                for (int row = Grid.MAX_ROWS - 2; row >= 0; row--) {
                    if (squares[row][column] != null && squares[row][column].getTile() != null) {

                        dropDown(squares, squareViews, row, column);
                    }
                }
            }

            ArrayList<SquareView> droppedSquareView = new ArrayList<SquareView>();

            for (int row = 0; row < Grid.MAX_ROWS; row++) {
                for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                    if (squares[row][column] != null && squares[row][column].isEmpty() && !squares[row][column].isContainer()) {
                        squares[row][column].setTile(grid.getNewTile());
                        squareViews[row][column].actived();
                        squareViews[row][column].repaint();
                        droppedSquareView.add(squareViews[row][column]);
                    }
                }
            }

            Timer timer = new Timer();
            timer.schedule(new recoverTile(droppedSquareView), 1000);

            return true;
        } else {
            return false;
        }
    }

    void dropDown(Square[][] squares, SquareView[][] squareViews, int row, int column) {
        int dropDistance = 0;

        while (row + 1 + dropDistance < Grid.MAX_ROWS && squares[row + 1 + dropDistance][column] != null && squares[row + 1 + dropDistance][column].getTile() == null) {
            dropDistance++;
        }

        if (dropDistance > 0) {
            squares[row + dropDistance][column].setTile(squares[row][column].getTile());
            squares[row][column].setTile(null);
            squareViews[row][column].repaint();
            squareViews[row + dropDistance][column].repaint();
        }
    }

    class recoverTile extends TimerTask {

        ArrayList<SquareView> droppedSquareView;

        public recoverTile(ArrayList<SquareView> droppedSquareView) {
            this.droppedSquareView = droppedSquareView;
        }

        @Override
        public void run() {
            for(Iterator<SquareView> squareViewIterator= droppedSquareView.iterator();squareViewIterator.hasNext();) {
                SquareView squareView = squareViewIterator.next();
                squareView.inactive();
                squareView.normal();
            }
        }
    }
}
