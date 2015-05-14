package application.Models;

import java.io.Serializable;

/**
 *
 */
public class SpecialMoveLeft implements Serializable {

    Value resetBoardSpecialMove;
    Value removeTileSpecialMove;
    Value swapTileSpecialMove;


    public SpecialMoveLeft(
            Value resetBoardSpecialMove,
            Value removeTileSpecialMove,
            Value swapTileSpecialMove) {
        this.resetBoardSpecialMove = resetBoardSpecialMove;
        this.removeTileSpecialMove = removeTileSpecialMove;
        this.swapTileSpecialMove = swapTileSpecialMove;
    }

    public Value getResetBoardSpecialMoveLetf() {
        return resetBoardSpecialMove;
    }

    public void setResetBoardSpecialMoveLetf(Value resetBoardSpecialMoveLetf) {
        this.resetBoardSpecialMove = resetBoardSpecialMoveLetf;
    }

    public Value getRemoveTileSpecialMove() {
        return removeTileSpecialMove;
    }

    public void setRemoveTileSpecialMove(Value removeTileSpecialMove) {
        this.removeTileSpecialMove = removeTileSpecialMove;
    }

    public Value getSwapTileSpecialMove() {
        return swapTileSpecialMove;
    }

    public void setSwapTileSpecialMove(Value swapTileSpecialMove) {
        this.swapTileSpecialMove = swapTileSpecialMove;
    }
}