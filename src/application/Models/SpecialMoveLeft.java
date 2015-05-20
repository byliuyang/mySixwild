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

        public Value getResetBoardSpecialMove() {
            return resetBoardSpecialMove;
        }

        public void setResetBoardSpecialMove(Value resetBoardSpecialMove) {
            this.resetBoardSpecialMove = resetBoardSpecialMove;
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