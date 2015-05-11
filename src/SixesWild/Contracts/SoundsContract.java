package SixesWild.Contracts;

/**
 * Created by harryliu on 5/7/15.
 */
public class SoundsContract {

    //    Sounds directory
    final static String SOUNDS_PATH = "/sounds";

    //    Drop tile sound
    public static final String DROP_TILE_SOUND = SOUNDS_PATH + "/fallDown.wav";
    //    Level win sound
    public static final String WIN_LEVEL_SOUND = SOUNDS_PATH + "/win.wav";

    //    Remove tile special move sound
    public static final String REMOVE_TILE_SPECIAL_MOVE_SOUND = SOUNDS_PATH + "/removeTileSpecialMove.wav";

    //    Swap square special move sound
    public static final String SWAP_SQUARE_SPECIAL_MOVE_SOUND = SOUNDS_PATH + "/swap.wav";

    //    Reset board special move sound
    public static final String RESET_BOARD_SPECIAL_MOVE_SOUND = SOUNDS_PATH + "/refresh.wav";

    public static final String RESTART_LEVEL_SOUND = SOUNDS_PATH + "/refresh.wav";
}
