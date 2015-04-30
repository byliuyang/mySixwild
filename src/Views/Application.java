package Views;

import Views.Screens.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Application extends JFrame {

    //    Application name
    public static final String APP_NAME = "SixesWild";

    //    window width
    public static final int WINDOW_WIDTH = 1024;
    //    windows height
    public static final int WINDOW_HEIGHT = 768;
    /**
     *
     */
    JPanel titlePanel;
    /**
     *
     */
    MenuScreen menuScreen;
    /**
     *
     */
    GameScreen gameScreen;
    /**
     *
     */
    BadgesScreen badgesScreen;
    /**
     *
     */
    LevelsScreen levelsScreen;
    /**
     *
     */
    AboutScreen aboutScreen;
    /**
     *
     */
    AnimationManager animationManager;

    /**
     *
     */
    public Application() {
        super(Application.APP_NAME);
        this.setSize(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        this.setContentPane(layeredPane);

        this.add(new JLabel("aa"), new Integer(1));

    }
}