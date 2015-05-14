package application.Moves.AutoMoves;

import application.Models.Levels.Level;
import application.Moves.IMove;
import application.Views.Application;

/**
 *
 */
public class GetBadgeAutoMove implements IMove {


    Level level;

    public GetBadgeAutoMove(Level level) {
        this.level = level;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean doMove(Application app) {
        return false;
    }
}