package application.Views.Screens.LevelScreenPackage;

import application.Models.Grid;
import application.Models.Levels.Level;
import application.Models.Square;
import application.Views.Application;
import application.Views.Components.NavigationBar;
import application.Views.IModelUpdated;
import application.Views.TransitableView;

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

    final Color SQUARE_NORMAL_BACK_COLOR = new Color(72, 111, 74);
    final Color SQUARE_HOVERED_BACK_COLOR = new Color(250, 212, 0);
    final Color SQUARE_DISABLED_BACK_COLOR = new Color(165, 165, 165);

    final Color PREVIEW_GRID_BACK_COLOR = new Color(72,111,74);

    PreviewSquareView[][] previewSquareViews;
    Application app;

    public PreviewGridView(Application app) {
        this.app = app;

        setPreferredSize(GRID_VIEW_SIZE);
        setMaximumSize(GRID_VIEW_SIZE);
        setMinimumSize(GRID_VIEW_SIZE);

        setBackground(PREVIEW_GRID_BACK_COLOR);
        setLayout(null);
    }

    public void initialize(Level level) {

        removeAll();

        Grid grid = level.getGrid();

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
                    previewSquareView.normal();
                }
            }
        }
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
