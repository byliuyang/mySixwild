package SixesWild.Views.Components;

import SixesWild.Contracts.ImageContract;
import SixesWild.Views.Application;
import SixesWild.Views.Screens.FlipPageScreen;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class FlipPagePanel extends JPanel {

    //    Panel back ground color
    public final Color PANEL_BACK_COLOR = new Color(249, 246, 242);
    //    Size of flip page buttons
    public final Dimension FLIP_PAGE_BUTTON_SIZE = new Dimension(76, 76);

    //    Flip page button padding
    public final int FLIP_PAGE_BUTTON_PADDING = 35;

    //    Last page button bounds
    public final Rectangle LAST_PAGE_BUTTON_BOUNDS = new Rectangle(
            FLIP_PAGE_BUTTON_PADDING,
            225,
            (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            (int) FLIP_PAGE_BUTTON_SIZE.getHeight()
    );

    //    Next page button bounds
    public final Rectangle NEXT_PAGE_BUTTON_BONDS = new Rectangle(
            Application.WINDOW_WIDTH
                    - FLIP_PAGE_BUTTON_PADDING
                    - (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            225,
            (int) FLIP_PAGE_BUTTON_SIZE.getWidth(),
            (int) FLIP_PAGE_BUTTON_SIZE.getHeight()
    );

    //    Flip page panel last page button
    ImageButton lastPageButton;
    //    Flip page panel next page button
    ImageButton nextPageButton;
    //    Flip page button list panel
    ListPanel listPanel;

//    Flip page screen
    FlipPageScreen flipPageScreen;

    //    Flip page panel page indicator
    PageIndicator pageIndicator;

    public FlipPagePanel(FlipPageScreen flipPageScreen) {
        this.flipPageScreen = flipPageScreen;

        initialize();
    }

    void initialize() {
        setLayout(null);
        setOpaque(true);
        setBackground(PANEL_BACK_COLOR);

        getLastPageButton().setPreferredSize(FLIP_PAGE_BUTTON_SIZE);
        getLastPageButton().setBounds(LAST_PAGE_BUTTON_BOUNDS);
        add(lastPageButton);

        getNextPageButton().setPreferredSize(FLIP_PAGE_BUTTON_SIZE);
        getNextPageButton().setBounds(NEXT_PAGE_BUTTON_BONDS);
        add(nextPageButton);
    }

    public ImageButton getLastPageButton() {
        if (lastPageButton == null) {

            lastPageButton = new ImageButton(
                    ImageContract.LAST_PAGE_BUTTON_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_DISABLED_IMAGE,
                    ImageContract.LAST_PAGE_BUTTON_HOVERED_IMAGE,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR
            );
        }

        return lastPageButton;
    }

    public void setLastPageButton(ImageButton lastPageButton) {
        this.lastPageButton = lastPageButton;
    }

    public ImageButton getNextPageButton() {
        if (nextPageButton == null) {

            nextPageButton = new ImageButton(
                    ImageContract.NEXT_PAGE_BUTTON_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_HOVERED_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_DISABLED_IMAGE,
                    ImageContract.NEXT_PAGE_BUTTON_HOVERED_IMAGE,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR,
                    PANEL_BACK_COLOR
            );
        }

        return nextPageButton;
    }

    public void setNextPageButton(ImageButton nextPageButton) {
        this.nextPageButton = nextPageButton;
    }

    public void setListPanel(ListPanel listPanel) {
        this.listPanel = listPanel;
    }

    public PageIndicator getPageIndicator() {
        return pageIndicator;
    }

    public void setPageIndicator(PageIndicator pageIndicator) {
        this.pageIndicator = pageIndicator;
    }

    public ListPanel getListPanel() {
        return listPanel;
    }

    public FlipPageScreen getFlipPageScreen() {
        return flipPageScreen;
    }

    public void setFlipPageScreen(FlipPageScreen flipPageScreen) {
        this.flipPageScreen = flipPageScreen;
    }
}