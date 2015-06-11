package application.Models.Badges;

import application.Views.Application;

/**
 * Created by harryliu on 5/21/15.
 */
public class ContinuousMovesBadge extends Badge {

    int numberContinuousMove;
    int numberTiles;

    public ContinuousMovesBadge(boolean unlockState, int numberContinuousMove, int numberTiles) {
        super(unlockState);
        this.numberContinuousMove = numberContinuousMove;
        this.numberTiles = numberTiles;
    }

    public ContinuousMovesBadge(boolean unlockState, String name, String introduction, String icon, int numberContinuousMove, int numberTiles) {
        super(unlockState, name, introduction, icon);
        this.numberContinuousMove = numberContinuousMove;
        this.numberTiles = numberTiles;
    }

    @Override
    public boolean isValid(Application app) {
        return false;
    }
}
