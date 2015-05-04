package SixesWild.Views.Components;

import SixesWild.Utilities;
import SixesWild.Views.Screens.Screen;

import java.awt.*;

public abstract class StarsView extends Canvas {

    //    Star view paddings
    final int PADDING_TOP = 0;
    final int PADDING_LEFT = 0;

    final int STAR_PADDING_TOP = 2;

    Image starActiveImage;
    Image starInactiveImage;

    //    Number of stars
    int star;
    //    Buffer image
    Image bufferedImage;
    //    Graphics2D object
    Graphics2D graphics2D;
    //    Gap between stars
    int gapBetweenStars;

    public StarsView(int star) {
        this.star = star;
    }

    void ensureImageAvaliable() {
        if (bufferedImage == null) {
            bufferedImage = this.createImage(
                    (int) getPreferredSize().getWidth(),
                    (int) getPreferredSize().getHeight()
            );

            graphics2D = (Graphics2D) bufferedImage.getGraphics();
        }
    }

    void redrawState() {
        ensureImageAvaliable();
        Utilities.setHighQuality(graphics2D);

        graphics2D.setColor(Screen.SCREEN_BACK_COLOR);

        graphics2D.fillRect(
                PADDING_LEFT,
                PADDING_TOP,
                (int) getPreferredSize().getWidth(),
                (int) getPreferredSize().getHeight()
        );

        switch (star) {
            case 1:
                drawOneStar();
                break;
            case 2:
                drawTwoStars();
                break;
            case 3:
                drawThreeStars();
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (g == null) {
            return;
        }

        redrawState();

        Utilities.setHighQuality(g);

        g.drawImage(bufferedImage, PADDING_TOP, PADDING_LEFT, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), this);
    }

    void drawOneStar() {
//        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

//        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starInactiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);

//        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starInactiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);
    }

    void drawTwoStars() {
        //        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starInactiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starInactiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starInactiveImage.getWidth(this),
                starInactiveImage.getHeight(this),
                this);
    }

    void drawThreeStars() {
        //        1st star
        int smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2
                - starActiveImage.getWidth(this)
                - gapBetweenStars;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        2nd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                - starActiveImage.getWidth(this)) / 2;

        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);

        //        3rd star
        smallStarPaddingLeft = ((int) getPreferredSize().getWidth()
                + starActiveImage.getWidth(this)) / 2
                +gapBetweenStars;
        graphics2D.drawImage(
                starActiveImage,
                smallStarPaddingLeft,
                STAR_PADDING_TOP,
                starActiveImage.getWidth(this),
                starActiveImage.getHeight(this),
                this);
    }

    //    Getters and setters
    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Image getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(Image bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}