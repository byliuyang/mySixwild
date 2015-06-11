package application.Contracts;

import application.Models.Badges.Badge;
import application.Models.Badges.ContinuousMovesBadge;
import application.Models.Badges.ScoreBadge;

/**
 * Created by harryliu on 5/23/15.
 */
public class BadgeContract {

//    Score badge

    public static final Badge SCORE_BADGE_TWO = new ScoreBadge(
            false,
            "",
            "",
            "",
            180
    );

    public static final Badge SCORE_BADGE_THREE = new ScoreBadge(
            false,
            "",
            "",
            "",
            810
    );

    public static final Badge SCORE_BADGE_FOUR = new ScoreBadge(
            false,
            "",
            "",
            "",
            3240
    );

    public static final Badge SCORE_BADGE_FIVE = new ScoreBadge(
            false,
            "",
            "",
            "",
            12150
    );

    public static final Badge SCORE_BADGE_SIX = new ScoreBadge(
            false,
            "",
            "",
            "",
            43740
    );

//    Continuous moves badge

//    Three tiles
    public static final Badge CONTINUOUS_BADGE_TWO_THREE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            3,
            2
    );

    public static final Badge CONTINUOUS_BADGE_TWO_FIVE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            5,
            2
    );

    public static final Badge CONTINUOUS_BADGE_TWO_TEN = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            10,
            2
    );

//    Three tiles
    public static final Badge CONTINUOUS_BADGE_THREE_THREE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            3,
            3
    );

    public static final Badge CONTINUOUS_BADGE_THREE_FIVE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            5,
            3
    );

    public static final Badge CONTINUOUS_BADGE_THREE_TEN = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            10,
            3
    );

//    Four tiles
    public static final Badge CONTINUOUS_BADGE_FOUR_THREE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            3,
            4
    );

    public static final Badge CONTINUOUS_BADGE_FOUR_FIVE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            5,
            4
    );

    public static final Badge CONTINUOUS_BADGE_FOUR_TEN = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            10,
            4
    );

//    Five tiles
    public static final Badge CONTINUOUS_BADGE_FIVE_THREE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            3,
            5
    );

    public static final Badge CONTINUOUS_BADGE_FIVE_FIVE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            5,
            5
    );

    public static final Badge CONTINUOUS_BADGE_FIVE_TEN = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            10,
            5
    );

//    Six tiles
    public static final Badge CONTINUOUS_BADGE_SIX_THREE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            3,
            6
    );

    public static final Badge CONTINUOUS_BADGE_SIX_FIVE = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            5,
            6
    );

    public static final Badge CONTINUOUS_BADGE_SIX_TEN = new ContinuousMovesBadge(
            false,
            "",
            "",
            "",
            10,
            6
    );
}
