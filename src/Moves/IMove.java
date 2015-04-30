package Moves;

/**
 *
 */
public interface IMove {

    /**
     * @return
     */
    public boolean isValid();

    /**
     * @return
     */
    public boolean doMove();

    /**
     * @return
     */
    public boolean undo();

}