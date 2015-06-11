package application.Models.Badges;

import application.Views.Application;

import java.awt.*;

/**
 * Created by harryliu on 5/21/15.
 */
public class ScoreBadge extends Badge {

    int score;

    public ScoreBadge(boolean unlockState, int score) {
        super(unlockState);
        this.score = score;
    }

    public ScoreBadge(boolean unlockState, String name, String introduction, String icon, int score) {
        super(unlockState, name, introduction, icon);
        this.score = score;
    }

    @Override
    public boolean isValid(Application app) {
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
