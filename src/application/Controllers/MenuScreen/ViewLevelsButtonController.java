package application.Controllers.MenuScreen;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class ViewLevelsButtonController extends ButtonController {

    Application app;

    public ViewLevelsButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.switchTo(app.getLevelsScreen());
    }
}