package SixesWild.Controllers.ViewLevelScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Levels.LightningLevel;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Screens.LevelScreenPackage.LevelDetailPanel;

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
        level.getScore().setCurrentScore(Utilities.ZERO);

        if (level instanceof LightningLevel) {

            ((LightningLevel) level).getTime().setCurrentTime(Utilities.ZERO);
        }

        app.switchTo(app.getGameScreen());

        app.getGameScreen().setLevel(level);
        app.getGameScreen().initialize();
        app.getGameScreen().modelChanged();
    }
}