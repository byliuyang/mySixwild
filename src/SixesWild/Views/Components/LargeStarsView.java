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
public class LargeStarsView extends StarsView {
    //    Distance between stars
    final int GAP_BETWEEN_STARS = 12;

    //    Large star view default dimension
    final Dimension LARGE_STAR_VIEW_SIZE = new Dimension(140, 28);

    public LargeStarsView(int star) {
        super(star);

        try {
            starActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_LARGE_ACTIVE_IMAGE));
            starInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_LARGE_INACTIVE_IMAGE));
            gapBetweenStars = GAP_BETWEEN_STARS;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setPreferredSize(LARGE_STAR_VIEW_SIZE);
        redrawState();
        repaint();
    }
}
