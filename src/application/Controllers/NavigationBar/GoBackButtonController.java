package application.Controllers.NavigationBar;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class GoBackButtonController extends ButtonController {

    Application app;

    public GoBackButtonController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.switchTo(app.getMenuScreen());
    }
}