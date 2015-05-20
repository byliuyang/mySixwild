package application.Views.Screens.AboutScreenPackage;

import application.Contracts.ImageContract;
import application.Utilities;
import application.Views.Application;
import application.Views.Components.BufferedCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by harryliu on 5/2/15.
 */
public class DeveloperIntroPicture extends BufferedCanvas {

    Image teamIntroductionImage;

    public DeveloperIntroPicture() {
        try {
            this.teamIntroductionImage = ImageIO.read(new File(System.getProperty(Application.ROOT_PATH) + ImageContract.TEAM_INTRODUCTION_IMAGE));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void redrawState() {

        super.redrawState();

        int imageWidth = teamIntroductionImage.getWidth(this);
        int imageHeight = teamIntroductionImage.getHeight(this);

        int padddingLeft = ((int) getPreferredSize().getWidth() - imageWidth) / 2;
        int padddingTop = ((int) getPreferredSize().getHeight() - imageHeight) / 2 - 16;

        Utilities.setHighQuality(graphics2D);

        graphics2D.drawImage(teamIntroductionImage, padddingLeft, padddingTop, imageWidth, imageHeight, this);
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            return;
        }

        Utilities.setHighQuality(g);

        g.drawImage(bufferedImage, PADDING_TOP, PADDING_LEFT, (int) getMinimumSize().getWidth(), (int) getMinimumSize().getHeight(), this);
    }
}
