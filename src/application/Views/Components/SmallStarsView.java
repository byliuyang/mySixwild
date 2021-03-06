package application.Views.Components;

/**
 * Created by harryliu on 5/2/15.
 */

import application.Contracts.ImageContract;
import application.Views.Application;

import javax.imageio.ImageIO;
import java.io.File;

/**
 *
 */
public class SmallStarsView extends StarsView {

    //    Distance between stars
    final int GAP_BETWEEN_STARS = 6;


    public SmallStarsView(int star) {
        super(star);

        try {
            starActiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_ACTIVE_IMAGE));
            starInactiveImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.STAR_SMALL_INACTIVE_IMAGE));
            gapBetweenStars = GAP_BETWEEN_STARS;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
