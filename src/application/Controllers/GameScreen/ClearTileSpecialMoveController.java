package application.Controllers.GameScreen;

import application.Moves.SpecialMoves.ClearTileSpecialMove;
import application.Views.Application;
import application.Views.Components.SpecialMoveNavigationBar;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class ClearTileSpecialMoveController extends SpecialMoveButtonController {

    public ClearTileSpecialMoveController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar, Application app) {
        super(button, specialMoveNavigationBar, app);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressed(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (specialMoveNavigationBar.getSpecialMoveLeft().getRemoveTileSpecialMove().getValue() > 0) {
            super.mouseEntered(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (specialMoveNavigationBar.getSpecialMoveLeft().getRemoveTileSpecialMove().getValue() > 0) {
            app.getGameScreen().getGridView().setSpecialMove(new ClearTileSpecialMove(app.getGameScreen().getGridView().getGrid(), app.getGameScreen().getLevel()));
            super.mousePressed(e);
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}