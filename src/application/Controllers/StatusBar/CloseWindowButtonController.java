package application.Controllers.StatusBar;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class CloseWindowButtonController extends ButtonController {

    public CloseWindowButtonController(StyledButton button) {
        super(button);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(Application.EXECUTION_FINE);
    }
}