package application.Contracts;

/**
 * Created by harryliu on 5/5/15.
 */
public class TextContact {

    //    Banner title
    public static final String BANNER_TITLE = "SixesWild";

    //    Text of navigation buttons
    public static final String CONTINUE_BUTTON_TEXT = "Contiune Game";
    public static final String LEVEL_BUTTON_TEXT = "View Levels";
    public static final String BADGE_BUTTON_TEXT = "Achievements";
    public static final String ABOUT_BUTTON_TEXT = "Developer";

    //    Title of application
    public static final String APPLICATION_TITLE = "SixesWild";

    //    Title of individual screens
    public static final String ABOUT_SCREEN_TITLE = "Developer";
    public static final String LEVELS_SCREEN_TITLE = "Levels";
    public static final String BADGE_SCREEN_TITLE = "Achievement Badges";

    //    Score label text
    public static final String SCORE_LABEL_TEXT = "Score: ";

    public static final String MOVE_LEFT_LABEL_TEXT = "Moves remain: ";

    public static final String NOT_MARKED_LABEL_TEXT = "Marks remain: ";

    public static final String EMPTY_LABEL_TEXT = "Boxes remain: ";

    public static final String TIME_REMAIN_LABEL_TEXT = "Time: ";

    public static final String LEVEL_ID = "Level: ";

    public static final String LEVEL= "LEVEL";

    public static final String LEVEL_TYPE_PUZZLE  = "Puzzle";
    public static final String LEVEL_TYPE_LIGHTNING  = "Lightning";
    public static final String LEVEL_TYPE_ELIMINATION  = "Elimination";
    public static final String LEVEL_TYPE_RELEASE  = "Release";

    public static final String LEVEL_INTRO_PUZZLE =
            "<html>" +
                "<ul>" +
                    "<li>Each move removes squares from grid</li>" +
                    "<li>Contents repopulated by shifting downward to fill in holes, with new squares appearing at top</li>" +
                "</ul>" +
            "<html>";
    public static final String LEVEL_INTRO_LIGHTNING =
            "<html>" +
                    "<ul>" +
                        "<li>Complete as many moves within fixed time period</li>" +
                    "</ul>" +
            "</html>";
    public static final String LEVEL_INTRO_ELIMINATION =
            "<html>" +
                    "<ul>" +
                        "<li>Each selected square is marked</li>" +
                        "<li>Level complete once all squares are marked in the grid</li>" +
                    "</ul>" +
            "</html>";
    public static final String LEVEL_INTRO_RELEASE =
            "<html>" +
                    "<ul>" +
                        "<li>Each “6” is a block</li>" +
                        "<li>As regions are formed, the “6” fall downward</li>" +
                        "<li>Once all are moved to their proper place, level completes</li>" +
                    "</ul>" +
            "</html>";
}
