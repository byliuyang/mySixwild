package application.Controllers.GameScreen;

import application.Moves.SpecialMoves.ResetBoardSpecialMove;
import application.Views.Application;
import application.Views.Components.SpecialMoveNavigationBar;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

public class ResetBoardSpecialMoveController extends SpecialMoveButtonController {

    public ResetBoardSpecialMoveController(StyledButton button, SpecialMoveNavigationBar specialMoveNavigationBar, Application app) {
        super(button, specialMoveNavigationBar, app);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (specialMoveNavigationBar.getSpecialMoveLeft().getResetBoardSpecialMove().getValue() > 0) {
            super.mouseEntered(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (specialMoveNavigationBar.getSpecialMoveLeft().getResetBoardSpecialMove().getValue() > 0) {
            super.mousePressed(e);
            ResetBoardSpecialMove move = new ResetBoardSpecialMove(app.getGameScreen().getGridView().getGrid(), app.getGameScreen().getLevel());
            if (move.isValid()) {
                move.doMove(app);

                SpecialMoveNavigationBar specialMoveNavigationBar = ((SpecialMoveNavigationBar) app.getGameScreen().getNavigationBar());

                specialMoveNavigationBar.getSpecialMoveLeft().getResetBoardSpecialMove().decrease(1);
                specialMoveNavigationBar.setAllMoveButtonNormal();

                specialMoveNavigationBar.getResetBoardSpecialMoveView().modelChanged();

                app.getGameScreen().getGridView().setSpecialMove(null);
            }
        } else {
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}