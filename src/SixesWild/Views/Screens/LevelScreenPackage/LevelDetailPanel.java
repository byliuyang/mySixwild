package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Contracts.TextContact;
import SixesWild.Controllers.ViewLevelScreen.StartLevelButtonController;
import SixesWild.Models.Levels.*;
import SixesWild.Utilities;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.ImageButton;
import SixesWild.Views.Components.LargeStarsView;
import SixesWild.Views.Components.NavigationBar;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class LevelDetailPanel extends DetailPanel {


    //    Level name font size
    final float LEVEL_NAME_FONT_SIZE = 36L;

    //    Level name label bounds
    final Rectangle LEVEL_NAME_BOUNDS = new Rectangle(190, 42, 130, 50);

    //    Level type font size
    final float LEVEL_TYPE_FONT_SIZE = 24L;

    //    Level name label bounds
    final Rectangle LEVEL_TYPE_BOUNDS = new Rectangle(190, 72, 130, 50);

    //    Level introduction font size
    final float LEVEL_INTRO_FONT_SIZE = 18L;

    //    Level introduction label bounds
    final Rectangle LEVEL_INTRO_BOUNDS = new Rectangle(320, 20, 480, 100);

    //    Start level button size
    final Dimension START_LEVEL_BUTTON_SIZE = new Dimension(140, 46);

    //    Start level button bounds
    final Rectangle START_LEVEL_BUTTON_BOUNDS = new Rectangle(850, 74, 140, 46);

    //    Star view size
    final Dimension STAR_VIEW_SIZE = new Dimension(96, 28);

    //    Star view bounds
    final Rectangle STAR_VIEW_BOUNDS = new Rectangle(893, 30, 96, 28);

    final Rectangle PREVIEW_GRID_VIEW_BOUNDS = new Rectangle(6, 6, 142, 142);


    JLabel levelNameLabel;

    JLabel levelTypeLabel;

    JLabel levelIntroLabel;

    LargeStarsView largeStars;

    ImageButton startLevelButton;

    Level level;

    PreviewGridView previewGridView;

    Application app;

    public LevelDetailPanel(Application app) {


        setLayout(null);
        setBackground(DETAIL_PANEL_BACK_COLOR);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_NAME_FONT_SIZE);
        //       Setup level name label
        levelNameLabel = new JLabel();
        levelNameLabel.setFont(Utilities.normalFont);
        levelNameLabel.setForeground(Color.WHITE);
        levelNameLabel.setOpaque(false);
        levelNameLabel.setBounds(LEVEL_NAME_BOUNDS);
        add(levelNameLabel);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_TYPE_FONT_SIZE);
        levelTypeLabel = new JLabel();
        levelTypeLabel.setFont(Utilities.normalFont);
        levelTypeLabel.setForeground(Color.WHITE);
        levelTypeLabel.setOpaque(false);
        levelTypeLabel.setBounds(LEVEL_TYPE_BOUNDS);
        add(levelTypeLabel);

        Utilities.normalFont = Utilities.normalFont.deriveFont(LEVEL_INTRO_FONT_SIZE);
        //        Setup level intro label
        levelIntroLabel = new JLabel();
        levelIntroLabel.setFont(Utilities.normalFont);
        levelIntroLabel.setForeground(Color.WHITE);
        levelIntroLabel.setOpaque(false);
        levelIntroLabel.setBounds(LEVEL_INTRO_BOUNDS);
        add(levelIntroLabel);

        //        Setup level intro label
        startLevelButton = new ImageButton(
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                ImageContract.START_LEVEL_BUTTON_HOVERED_IMAGE,
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                ImageContract.START_LEVEL_BUTTON_NORMAL_IMAGE,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR,
                DETAIL_PANEL_BACK_COLOR,
                NavigationBar.NO_ROUND
        );

        startLevelButton.setPreferredSize(START_LEVEL_BUTTON_SIZE);
        startLevelButton.setMinimumSize(START_LEVEL_BUTTON_SIZE);
        startLevelButton.setMaximumSize(START_LEVEL_BUTTON_SIZE);

        startLevelButton.setBounds(START_LEVEL_BUTTON_BOUNDS);
        StartLevelButtonController startLevelButtonController = new StartLevelButtonController(startLevelButton, this, app);

        startLevelButton.addMouseListener(startLevelButtonController);
        startLevelButton.addMouseMotionListener(startLevelButtonController);

        startLevelButton.repaint();

        add(startLevelButton);


//        Large star view
        largeStars = new LargeStarsView(0);
        largeStars.setPreferredSize(STAR_VIEW_SIZE);
        largeStars.setMaximumSize(STAR_VIEW_SIZE);
        largeStars.setMinimumSize(STAR_VIEW_SIZE);

        largeStars.setBounds(STAR_VIEW_BOUNDS);

        add(largeStars);
        largeStars.repaint();

        getPreviewGridView().setBounds(PREVIEW_GRID_VIEW_BOUNDS);
        add(getPreviewGridView());
    }

    public void setLevel(Level level) {

        this.level = level;
        //        Setup level type label

        levelNameLabel.setText(TextContact.LEVEL + " " + level.getId().toString());

        String levelType = null;
        String levelIntro = null;

        if (level instanceof PuzzleLevel) {

            levelType = TextContact.LEVEL_TYPE_PUZZLE;
            levelIntro = TextContact.LEVEL_INTRO_PUZZLE;

        } else if (level instanceof LightningLevel) {

            levelType = TextContact.LEVEL_TYPE_LIGHTNING;
            levelIntro = TextContact.LEVEL_INTRO_LIGHTNING;

        } else if (level instanceof EliminationLevel) {

            levelType = TextContact.LEVEL_TYPE_ELIMINATION;
            levelIntro = TextContact.LEVEL_INTRO_ELIMINATION;

        } else if (level instanceof ReleaseLevel) {

            levelType = TextContact.LEVEL_TYPE_RELEASE;
            levelIntro = TextContact.LEVEL_INTRO_RELEASE;
        }

        levelTypeLabel.setText(levelType);
        levelIntroLabel.setText(levelIntro);

        largeStars.setStar(level.getScore().getStarNumber());

        getPreviewGridView().initialize(level);
        getPreviewGridView().modelChanged();
    }

    public PreviewGridView getPreviewGridView() {
        if (previewGridView == null) {
            previewGridView = new PreviewGridView(app);
        }

        return previewGridView;
    }

    public Level getLevel() {
        return level;
    }
}