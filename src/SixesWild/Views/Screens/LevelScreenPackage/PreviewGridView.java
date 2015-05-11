package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Models.Grid;
import SixesWild.Models.Levels.Level;
import SixesWild.Models.Square;
import SixesWild.Views.Application;
import SixesWild.Views.Components.NavigationBar;
import SixesWild.Views.IModelUpdated;
import SixesWild.Views.Screens.GameScreenPackage.SquareView;
import SixesWild.Views.Screens.Screen;
import SixesWild.Views.TransitableView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by harryliu on 5/11/15.
 */
public class PreviewGridView extends TransitableView implements IModelUpdated {

    //    Grid view size
    final Dimension GRID_VIEW_SIZE = new Dimension(142, 142);
    //    Grid view paddings
    final int GRID_VIEW_PADDING_LEFT = 4;
    final int GRID_VIEW_PADDING_TOP = 4;

    final Color SQUARE_NORMAL_BACK_COLOR = new Color(0, 0, 0, 0);
    final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    final Color PREVIEW_GRID_BACK_COLOR = new Color(0,0,0,40);

    PreviewSquareView[][] previewSquareViews;
    Application app;

    Grid grid;
    Level level;

    public PreviewGridView(Application app, Level level) {
        this.grid = level.getGrid();
        this.app = app;
        this.level = level;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(PREVIEW_GRID_BACK_COLOR);

        initialize();
    }

    public void initialize() {

        setLayout(null);

        previewSquareViews = new PreviewSquareView[Grid.MAX_ROWS][Grid.MAX_COLUMNS];

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Square square = grid.getSquare(row, column);
                if (square != null) {

                    PreviewSquareView previewSquareView = new PreviewSquareView(
                            SQUARE_NORMAL_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_HOVERED_BACK_COLOR,
                            SQUARE_DISABLED_BACK_COLOR,
                            square,
                            NavigationBar.NO_ROUND
                    );

                    previewSquareViews[row][column] = previewSquareView;

                    previewSquareView.setPreferredSize(PreviewSquareView.SQUARE_VIEW_SIZE);
                    previewSquareView.setMaximumSize(PreviewSquareView.SQUARE_VIEW_SIZE);
                    previewSquareView.setMinimumSize(PreviewSquareView.SQUARE_VIEW_SIZE);

                    previewSquareView.setBounds(
                            GRID_VIEW_PADDING_LEFT + column * ((int) PreviewSquareView.SQUARE_VIEW_SIZE.getWidth()),
                            GRID_VIEW_PADDING_TOP + row * ((int) PreviewSquareView.SQUARE_VIEW_SIZE.getHeight()),
                            (int) PreviewSquareView.SQUARE_VIEW_SIZE.getWidth(),
                            (int) PreviewSquareView.SQUARE_VIEW_SIZE.getHeight()
                    );

                    add(previewSquareView);

//                    SquareButtonController squareButtonController = new SquareButtonController(previewSquareView, this, app);
//                    previewSquareView.addMouseListener(squareButtonController);
//                    previewSquareView.addMouseMotionListener(squareButtonController);

                    previewSquareView.normal();
                }
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public PreviewSquareView[][] getSquareViews() {
        return previewSquareViews;
    }

    @Override
    public void modelChanged() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (previewSquareViews[row][column] != null) {
                    previewSquareViews[row][column].repaint();
                }
            }
        }
    }
}
