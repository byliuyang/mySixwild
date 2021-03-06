package application.Controllers.GameScreen;

import application.Controllers.ButtonController;
import application.Models.Value;
import application.Moves.AutoMoves.DropDownAutoMove;
import application.Moves.SpecialMoves.ClearTileSpecialMove;
import application.Moves.SpecialMoves.SwapSquareSpecialMove;
import application.Moves.SwapNeighborMove;
import application.Views.Application;
import application.Views.Components.SpecialMoveNavigationBar;
import application.Views.Components.StyledButton;
import application.Views.Screens.GameScreenPackage.GridView;
import application.Views.Screens.GameScreenPackage.SquareView;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/4/15.
 */
public class SquareButtonController extends ButtonController {

    final double X_LOWER_BOUND = (SquareView.SQUARE_VIEW_SIZE.getWidth() - SquareView.TILE_VIEW_SIZE.getWidth()) / 2;
    final double X_UPPER_BOUND = SquareView.SQUARE_VIEW_SIZE.getWidth() - X_LOWER_BOUND;

    final double Y_LOWER_BOUND = (SquareView.SQUARE_VIEW_SIZE.getHeight() - SquareView.TILE_VIEW_SIZE.getHeight()) / 2;
    final double Y_UPPER_BOUND = SquareView.SQUARE_VIEW_SIZE.getHeight() - Y_LOWER_BOUND;

    GridView gridView;
    Application app;

    public SquareButtonController(StyledButton button, GridView gridView, Application app) {
        super(button);
        this.gridView = gridView;
        this.app = app;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (((SquareView) button).getSquare().getTile() != null) {
            if (gridView.getSpecialMove() instanceof ClearTileSpecialMove) {
                gridView.beginMakeingMove();
                mouseEntered(e);

                ClearTileSpecialMove move = (ClearTileSpecialMove) gridView.getSpecialMove();
                gridView.setSpecialMove(move);

                if (move.isValid()) {
                    move.doMove(app);

                    DropDownAutoMove dropDownAutoMove = new DropDownAutoMove(
                            app.getGameScreen().getLevel(),
                            app.getGameScreen().getGridView().getGrid()
                    );
                    if (dropDownAutoMove.isValid()) {
                        dropDownAutoMove.doMove(app);
                    }

                } else {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }

                gridView.finishMakingMove();

            } else if (gridView.getSpecialMove() instanceof SwapSquareSpecialMove) {

                gridView.addActiveSquareView((SquareView) button);
                button.actived();
            } else if (!gridView.hasSpecialMove()) {

                gridView.beginMakeingMove();
                mouseEntered(e);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (((SquareView) button).getSquare().getTile() != null) {
            super.mouseEntered(e);
            if (gridView.isMakeingMove()) {
                if (!button.isActiveState()) {
                    button.actived();
                    gridView.addActiveSquareView((SquareView) button);
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!gridView.isMakeingMove()) {
            super.mouseExited(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (!gridView.hasSpecialMove()) {
            SwapNeighborMove move = new SwapNeighborMove(gridView.getGrid(), app.getGameScreen().getLevel());
            if (move.isValid()) {
                move.doMove(app);
                gridView.finishMakingMove();
                dropDown();

            } else {
                app.getGameScreen().updateScore(new Value(0));
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            gridView.finishMakingMove();
        } else if (gridView.getSpecialMove() instanceof ClearTileSpecialMove) {
            gridView.finishMakingMove();
            dropDown();

            SpecialMoveNavigationBar specialMoveNavigationBar = ((SpecialMoveNavigationBar) app.getGameScreen().getNavigationBar());

            specialMoveNavigationBar.getSpecialMoveLeft().getRemoveTileSpecialMove().decrease(1);
            specialMoveNavigationBar.setAllMoveButtonNormal();

            specialMoveNavigationBar.getClearSquareSpecialMoveView().modelChanged();

            gridView.setSpecialMove(null);

        } else if (gridView.getSpecialMove() instanceof SwapSquareSpecialMove) {
            SwapSquareSpecialMove move = (SwapSquareSpecialMove) gridView.getSpecialMove();
            if (move.isValid()) {

                move.doMove(app);
                gridView.finishMakingMove();
                dropDown();

                SpecialMoveNavigationBar specialMoveNavigationBar = ((SpecialMoveNavigationBar) app.getGameScreen().getNavigationBar());
                specialMoveNavigationBar.getSpecialMoveLeft().getSwapTileSpecialMove().decrease(1);
                specialMoveNavigationBar.setAllMoveButtonNormal();
                specialMoveNavigationBar.getSwapSquareSpecialMoveView().modelChanged();

                gridView.setSpecialMove(null);


            }
        }
    }

    private void dropDown() {
        DropDownAutoMove dropDownAutoMove = new DropDownAutoMove(
                app.getGameScreen().getLevel(),
                app.getGameScreen().getGridView().getGrid()
        );
        if (dropDownAutoMove.isValid()) {
            dropDownAutoMove.doMove(app);
        }
    }
}
