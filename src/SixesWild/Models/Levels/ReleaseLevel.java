package SixesWild.Models.Levels;

import SixesWild.Models.*;
import SixesWild.Utilities;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class ReleaseLevel extends Level {

    ArrayList<Square> sixReceivers;
    Value numNotEmpty;

    public ReleaseLevel(boolean unlockState) {
        super(unlockState);
    }

    public ReleaseLevel(boolean unlockState, Value id, Score score, Grid grid, SpecialMoveLeft specialMoveLeft, Probabilities probabilities) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);

        sixReceivers = new ArrayList<>();
        numNotEmpty = new Value(0);
    }

    public boolean hasWon() {
        if(getNumNotEmpty().getValue()==0) {
            return true;
        }

        return false;
    }

    public Value getNumNotEmpty() {
        int count = sixReceivers.size();
        for(Iterator<Square> squareIterator = sixReceivers.iterator(); squareIterator.hasNext();) {
            Square square = squareIterator.next();
            if(square.getTile()!=null && square.getTile().getNumber().getValue() == Utilities.SIX) {
                count--;
            }
        }

        numNotEmpty.setValue(count);

        return numNotEmpty;
    }

    public void addContainer(int row, int column) {
        grid.getSquares()[row][column].container();
        sixReceivers.add(grid.getSquares()[row][column]);
    }
}