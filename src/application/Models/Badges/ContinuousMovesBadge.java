package application.Models.Badges;

import application.Views.Application;

/**
 * Created by harryliu on 5/21/15.
 */
public class ContinuousMovesBadge extends Badge {

    int numberContinuousMove;

    public ContinuousMovesBadge(boolean unlockState, int numberContinuousMove) {
        super(unlockState);
        this.numberContinuousMove = numberContinuousMove;
    }

    @Override
    public boolean isValid(Application app) {
        return false;
    }
}
