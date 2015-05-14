package application.Controllers.GameScreen;

import application.Controllers.ButtonController;
import application.Moves.RestartLevelMove;
import application.Views.Application;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class RestartLevelController extends ButtonController {
    Application app;

    public RestartLevelController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        RestartLevelMove move = new RestartLevelMove(app.getGameScreen().getLevel());

        if (move.isValid()) {
            move.doMove(app);
            app.getGameScreen().modelChanged();

        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}