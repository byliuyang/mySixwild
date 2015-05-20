package application.Controllers.ViewLevelScreen;

import application.Controllers.ButtonController;
import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.StyledButton;
import application.Views.Screens.LevelScreenPackage.LevelDetailPanel;

import java.awt.event.MouseEvent;

/**
 *
 */
public class StartLevelButtonController extends ButtonController {

    Application app;
    LevelDetailPanel levelDetailPanel;

    public StartLevelButtonController(StyledButton button, LevelDetailPanel levelDetailPanel, Application app) {
        super(button);
        this.levelDetailPanel = levelDetailPanel;
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Level level = levelDetailPanel.getLevel();

        level.getGrid().generateTiles();

        level.getScore().setCurrentScore(Utilities.ZERO);

        if (level instanceof LightningLevel) {

            ((LightningLevel) level).getTime().setCurrentTime(Utilities.ZERO);
        }

        app.getGameScreen().setLevel(level);
        app.getGameScreen().initialize();
        app.getGameScreen().modelChanged();

        app.switchTo(app.getGameScreen());
    }
}