package application.Controllers.GameScreen;

import application.Controllers.ButtonController;
import application.Views.Application;
import application.Views.Components.SpecialMoveNavigationBar;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/5/15.
 */
public class SpecialMoveButtonController extends ButtonController {
    SpecialMoveNavigationBar specialMoveNavigationBar;
    Application app;

    public SpecialMoveButtonController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar, Application app) {
        super(button);
        this.specialMoveNavigationBar = specialMoveNavigationBar;
        this.app = app;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        specialMoveNavigationBar.setAllMoveButtonNormal();
        button.actived();
    }
}
