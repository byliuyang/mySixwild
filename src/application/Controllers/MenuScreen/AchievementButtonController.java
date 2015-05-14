package application.Controllers.MenuScreen;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class AchievementButtonController extends ButtonController {
    Application app;

    public AchievementButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.switchTo(app.getBadgesScreen());
    }
}
