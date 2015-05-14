package application.Moves;

import application.Views.Application;

/**
 *
 */
public interface IMove {

    public boolean isValid();

    public boolean doMove(Application app);

}