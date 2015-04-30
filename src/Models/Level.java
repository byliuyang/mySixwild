package Models;

import Moves.IMove;

import java.util.Stack;

/**
 *
 */
public abstract class Level extends Unlockable {

    /**
     *
     */
    Score score;

    /**
     *
     */
    Grid board;

    /**
     *
     */
    SpecialMoveLeft specialMoveLeft;

    /**
     *
     */
    Stack moves;

    /**
     *
     */
    IMove activeSpecialMove;

    /**
     *
     */
    public Level() {
    }


    /**
     * @return
     */
    public abstract boolean hasWon();

}