package SixesWild;

import SixesWild.Views.Application;

import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class Utilities {

    //    Numbers
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;

    //    Time
    public static final int ONE_SECOND = 1000;
    public static final int NO_DELAY = 0;

    //    Percentage
    public static final int ONE_HUNDRED = 100;
    public static final int ZERO = 0;

    public static Font normalFont;

    /**
     * Set graphics to be highest rendering quality
     *
     * @param g Target graphics
     */
    public static void setHighQuality(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }

    public static void loadFont() {
        try {

            normalFont = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty(Application.ROOT_PATH) + Application.REGULAR_FONT_LOCATION));

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}
