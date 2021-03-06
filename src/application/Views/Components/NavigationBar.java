package application.Views.Components;

import application.Contracts.ImageContract;
import application.Controllers.NavigationBar.GoBackButtonController;
import application.Views.Application;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class NavigationBar extends JPanel {

    //    No round
    public static final int NO_ROUND = 0;
    //    Button background color
    final Color BUTTON_BACK_COLOR = new Color(112, 147, 113);
    //    Button active background back color
    final Color BUTTON_ACTIVE_COLOR = new Color(103, 137, 104);
    //    Back button dimension
    final Dimension BACK_BUTTON_SIZE = new Dimension(58, 58);
    //    Back button bounds
    final Rectangle BACK_BUTTON_BOUNDS = new Rectangle(0, 0, 58, 58);
    //    Navigation bar background color
    final Color Nav_BAR_COLOR = new Color(112, 147, 113);
    //    Navigation bar title label font size
    final float TITLE_FONT_SIZE = 30L;
    //    Title label bounds
    final Rectangle NAV_LABEL_BOUNDS = new Rectangle(78, 0, 320, 58);
    //    Back button dimension
    final Dimension NAV_LABEL_SIZE = new Dimension(320, 58);
    //    Navigation bar title label alignment
    final boolean NAV_LABEL_LEFT_ALIGN = true;
    //    Back button
    ImageButton backButton;
    //    Application reference
    Application app;

    //    Navigation bar title label
    StyledLabel navTitleLabel;

    public NavigationBar(Application app) {
        this.app = app;
        initialize();
    }

    private void initialize() {
        setBackground(Nav_BAR_COLOR);
        setLayout(null);

        backButton = new ImageButton(
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                ImageContract.BACK_BUTTON_IMAGE,
                BUTTON_BACK_COLOR,
                BUTTON_ACTIVE_COLOR,
                BUTTON_BACK_COLOR,
                BUTTON_BACK_COLOR,
                NO_ROUND);

        backButton.setPreferredSize(BACK_BUTTON_SIZE);
        backButton.setMaximumSize(BACK_BUTTON_SIZE);
        backButton.setMinimumSize(BACK_BUTTON_SIZE);

        backButton.setBounds(BACK_BUTTON_BOUNDS);
//        backButton.setToolTipText(TipContract.BACK_TO_MAIN_MENU_BUTTON_TIP);
        backButton.addMouseListener(new GoBackButtonController(backButton, app));

        add(backButton);

        backButton.repaint();

    }

    public void setNavTitle(String navTitle) {

        if (navTitleLabel == null) {
            navTitleLabel = new StyledLabel(navTitle, TITLE_FONT_SIZE, Color.WHITE, NAV_LABEL_LEFT_ALIGN);

            navTitleLabel.setPreferredSize(NAV_LABEL_SIZE);
            navTitleLabel.setMaximumSize(NAV_LABEL_SIZE);
            navTitleLabel.setMinimumSize(NAV_LABEL_SIZE);

            navTitleLabel.setBounds(NAV_LABEL_BOUNDS);
            add(navTitleLabel);

            navTitleLabel.repaint();

        } else {
            navTitleLabel.setText(navTitle);
            navTitleLabel.repaint();
        }
    }
}