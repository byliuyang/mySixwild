package SixesWild.Views.Components;

/**
 * Created by harryliu on 5/2/15.
 */

import SixesWild.Contracts.ImageContract;
import SixesWild.Views.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 *
 */
public class SmallStarsView extends StarsView {

    //    Distance between stars
    final int GAP_BETWEEN_STARS = 6;

    //    Small star view default dimension
    public static final Dimension SMALL_STAR_VIEW_SIZE = new Dimension(72, 16);


    public SmallStarsView(int star) {
        super(star);

        try {
            starActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_ACTIVE_IMAGE));
            starInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_INACTIVE_IMAGE));
            gapBetweenStars = GAP_BETWEEN_STARS;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setPreferredSize(SMALL_STAR_VIEW_SIZE);
    }
}
