package SixesWild.Controllers.ViewLevelScreen;

import SixesWild.Controllers.FlipScreen.LockableButtonController;
import SixesWild.Models.Levels.Level;
import SixesWild.Views.Components.LockableButton;
import SixesWild.Views.Components.LockableButtonView;
import SixesWild.Views.Screens.LevelScreenPackage.LevelDetailPanel;
import SixesWild.Views.Screens.LevelScreenPackage.LevelListPanel;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class LevelButtonController extends LockableButtonController {
    Level level;
    LevelDetailPanel levelDetailPanel;


    public LevelButtonController(
            LockableButton button,
            LevelListPanel levelListPanel,
            LockableButtonView lockableButtonView,
            Level level,
            LevelDetailPanel levelDetailPanel) {

        super(button, levelListPanel, lockableButtonView);
        this.level = level;
        this.levelDetailPanel = levelDetailPanel;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!button.isDisableState()) {
            super.mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!button.isDisableState()) {
            super.mouseExited(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!button.isDisableState()) {
            levelDetailPanel.setLevel(level);
        }
    }
}
