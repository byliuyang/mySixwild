package Views.Screens;

import Models.Level;
import Views.ImageButton;
import Views.PopupBox;
import Views.ScoreLevelView;
import Views.SquareView;

/**
 *
 */
public class GameScreen extends NavigableScreen {

    /**
     *
     */
    Level level;
    /**
     *
     */
    SquareView[] activeSquareViews;
    /**
     *
     */
    ScoreLevelView scoreLevelView;
    /**
     *
     */
    PopupBox popupBox;
    /**
     *
     */
    ImageButton refreshButton;

    /**
     *
     */
    public GameScreen() {
    }


}