package application.Moves;

import application.Models.Levels.Level;
import application.Models.Time;
import application.Views.Application;
import application.Views.Components.LevelTimeRemainNavigationBar;

import java.util.TimerTask;

/**
 * Created by harryliu on 5/7/15.
 */
public class TimerAutoMove extends TimerTask {

    Time time;
    Level level;
    Application app;

    public TimerAutoMove(Application app, Level level, Time time) {
        this.time = time;
        this.level = level;
        this.app = app;
    }

    @Override
    public void run() {
        if (!level.hasWon()) {
            time.increase(1);
            ((LevelTimeRemainNavigationBar) app.getGameScreen().getNavigationBar()).modelChanged();
        } else {
            app.getGameScreen().levelCompleted();
        }
    }
}
