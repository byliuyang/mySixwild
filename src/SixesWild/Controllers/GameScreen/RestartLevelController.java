package SixesWild.Controllers.GameScreen;

import SixesWild.Controllers.ButtonController;
import SixesWild.Moves.RestartLevelMove;
import SixesWild.Moves.SpecialMoves.ResetBoardSpecialMove;
import SixesWild.Views.Application;
import SixesWild.Views.Components.StyledButton;
import SixesWild.Views.Screens.GameScreenPackage.GameScreen;

import java.awt.event.MouseEvent;

/**
 *
 */
public class RestartLevelController extends ButtonController{
    Application app;

    public RestartLevelController(StyledButton button, Application app) {
        super(button);
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        RestartLevelMove move = new RestartLevelMove(app.getGameScreen().getLevel());

        if(move.isValid()) {
            move.doMove(app);
            app.getGameScreen().modelChanged();

        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}