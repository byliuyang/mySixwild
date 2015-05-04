package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Contracts.ImageContract;
import SixesWild.Controllers.ViewLevelScreen.LevelButtonController;
import SixesWild.Models.Level;
import SixesWild.Views.Components.*;

import java.awt.*;

/**
 *
 */
public class LevelView extends LockableButtonView {


    //    Level button font size
    final float LEVEL_BUTTON_FONT_SIZE = 36L;

    //    Level button size
    final Dimension LEVEL_BUTTON_SIZE = new Dimension(72, 72);

    //    Level button bounds
    final Rectangle LEVEL_BUTTON_BOUNDS = new Rectangle(
            0,
            0,
            (int) LEVEL_BUTTON_SIZE.getWidth(),
            (int) LEVEL_BUTTON_SIZE.getHeight()
    );

    //    Star view bounds
    final Rectangle SMALL_STAR_VIEW_BOUNDS = new Rectangle(
            0,
            (int) (ListPanel.VIEW_SIZE.getHeight() - SmallStarsView.SMALL_STAR_VIEW_SIZE.getHeight()),
            (int) SmallStarsView.SMALL_STAR_VIEW_SIZE.getWidth(),
            (int) SmallStarsView.SMALL_STAR_VIEW_SIZE.getHeight()
    );

    //    Level button background color
    final Color LEVEL_BUTTON_NORMAL_BACK_COLOR = new Color(112, 147, 113);
    final Color LEVEL_BUTTON_HOVERED_BACK_COLOR = new Color(86, 116, 87);
    final Color LEVEL_BUTTON_ACTIVED_BACK_COLOR = new Color(141, 42, 54);
    final Color LEVEL_BUTTON_LOCKED_BACK_COLOR = new Color(149, 149, 149);

    //    Default lock state
    final boolean DEFAULT_LOCK_STATE = true;

    SmallStarsView smallStars;

    //    Level entity
    Level level;
    LevelDetailPanel levelDetailPanel;

    public LevelView(Level level, ListPanel listPanel, LevelDetailPanel levelDetailPanel) {
        super(listPanel);
        this.level = level;
        this.levelDetailPanel = levelDetailPanel;

        initialize();
    }

    void initialize() {

        setPreferredSize(ListPanel.VIEW_SIZE);
        setLayout(null);
        setOpaque(false);

//        Setup level button

        getLevelButton().setBounds(LEVEL_BUTTON_BOUNDS);

        LevelButtonController levelButtonController = new LevelButtonController(getLevelButton(), (LevelListPanel)getListPanel(), this, level, levelDetailPanel);
        getLevelButton().addMouseListener(levelButtonController);
        getLevelButton().addMouseMotionListener(levelButtonController);

        add(getLevelButton());

//        Setup star view

        getSmallStars().setBounds(SMALL_STAR_VIEW_BOUNDS);

        add(getSmallStars());
    }

    public LockableButton getLevelButton() {
        if (getButton() == null) {
//            int levelNumber = level.getLevelOrder();
            int levelNumber = 2;

            setButton(
                    new LevelButton(
                            new Integer(levelNumber).toString(),
                            LEVEL_BUTTON_FONT_SIZE,
                            Color.WHITE,
                            Color.WHITE,
                            Color.WHITE,
                            Color.WHITE,
                            LEVEL_BUTTON_NORMAL_BACK_COLOR,
                            LEVEL_BUTTON_HOVERED_BACK_COLOR,
                            LEVEL_BUTTON_ACTIVED_BACK_COLOR,
                            LEVEL_BUTTON_LOCKED_BACK_COLOR,
                            ImageContract.LEVEL_BUTTON_LOCKED_IMAGE,
                            DEFAULT_LOCK_STATE
                    ));

            getButton().setPreferredSize(LEVEL_BUTTON_SIZE);

        }
        return getButton();
    }

    public SmallStarsView getSmallStars() {
        if (smallStars == null) {
//            int starNumber = level.getScore.getNumStar();
            int starNumber = 2;

            smallStars = new SmallStarsView(starNumber);

            smallStars.setPreferredSize(SmallStarsView.SMALL_STAR_VIEW_SIZE);
        }
        return smallStars;
    }
}