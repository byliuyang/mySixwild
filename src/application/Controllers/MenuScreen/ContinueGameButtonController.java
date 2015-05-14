package application.Controllers.MenuScreen;

import application.Controllers.ButtonController;
import application.Models.Levels.LightningLevel;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class ContinueGameButtonController extends ButtonController {

    Application app;

    public ContinueGameButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!button.isDisableState()) {
            app.switchTo(app.getGameScreen());

            if (app.getGameScreen().getLevel() instanceof LightningLevel) {
                app.getGameScreen().resume();
            }
        }
    }
}