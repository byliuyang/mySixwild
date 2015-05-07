package SixesWild.Moves.AutoMoves;

import SixesWild.Models.Levels.Level;
import SixesWild.Moves.IMove;
import SixesWild.Views.Application;

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