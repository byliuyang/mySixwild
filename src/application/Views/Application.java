package application.Views;

import application.Contracts.TextContact;
import application.Models.*;
import application.Models.Levels.EliminationLevel;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Models.Levels.ReleaseLevel;
import application.Utilities;
import application.Views.Animation.AnimationManager;
import application.Views.Screens.AboutScreenPackage.AboutScreen;
import application.Views.Screens.BadgeScreenPackage.BadgesScreen;
import application.Views.Screens.GameScreenPackage.GameScreen;
import application.Views.Screens.LevelScreenPackage.LevelsScreen;
import application.Views.Screens.MenuScreenPackage.MenuScreen;
import application.Views.Screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

    //    Root path of application
    public static final String ROOT_PATH = "user.dir";

    public static final String LEVEL_PATH = "/levels";

    //    Font locations of regular, italic and bold.
    public static final String REGULAR_FONT_LOCATION = "/assets/AvenirNextRegular.ttf";
    public static final String ITALIC_FONT_LOCATION = "/assets/AvenirNextIt.ttf";
    public static final String BOLD_FONT_LOCATION = "/assets/AvenirNextBold.ttf";

    //    Application running state. 0 when execution when fine.
    public static final int EXECUTION_FINE = 0;

    //    Default Screen paddings
    final int DEFAULT_SCREEN_PADDING_LEFT = 0;
    final int DEFAULT_SCREEN_PADDING_TOP = 0;

    //    Screens
    MenuScreen menuScreen;
    GameScreen gameScreen;
    BadgesScreen badgesScreen;
    LevelsScreen levelsScreen;
    AboutScreen aboutScreen;

    JLayeredPane layeredPane;

    //    Current screen
    Screen currentScreen;

    //    Animation manager
    AnimationManager animationManager;

    public Application() {
        super(Application.APP_NAME);
        Utilities.loadFont();

        this.setSize(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT));
        this.setContentPane(layeredPane);

        this.setLayout(null);

        getMenuScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
        this.add(menuScreen);

        currentScreen = menuScreen;
    }

    public void switchTo(Screen screen) {
        if (currentScreen != null && screen != null) {

            if(currentScreen instanceof GameScreen) {
                ((GameScreen)currentScreen).suspend();
            }

            if((screen instanceof MenuScreen)) {
                if(getGameScreen().getLevel()!=null) {
                    getMenuScreen().getContinueButton().enabled();
                } else {
                    getMenuScreen().getContinueButton().disabled();
                }
            }

            getGraphics().clearRect(0, 0, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            screen.setVisible(true);
            currentScreen.setVisible(false);
            currentScreen = screen;
            repaint();
        }
    }

//    Getters

    public MenuScreen getMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(TextContact.APPLICATION_TITLE, this);
        }

        return menuScreen;
    }

    public GameScreen getGameScreen() {
        if (gameScreen == null) {
            gameScreen = new GameScreen(TextContact.APPLICATION_TITLE, this);

            getGameScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(gameScreen);
            getGameScreen().setVisible(false);
        }

        return gameScreen;
    }

    public BadgesScreen getBadgesScreen() {
        if (badgesScreen == null) {
            badgesScreen = new BadgesScreen(TextContact.APPLICATION_TITLE, this, TextContact.BADGE_SCREEN_TITLE);

            getBadgesScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(badgesScreen);
            getGameScreen().setVisible(false);
        }

        return badgesScreen;
    }

    public LevelsScreen getLevelsScreen() {
        if (levelsScreen == null) {
            levelsScreen = new LevelsScreen(TextContact.APPLICATION_TITLE, this, TextContact.LEVELS_SCREEN_TITLE);

            getLevelsScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(levelsScreen);
            getLevelsScreen().setVisible(false);
        }

        return levelsScreen;
    }

    public AboutScreen getAboutScreen() {
        if (aboutScreen == null) {
            aboutScreen = new AboutScreen(TextContact.APPLICATION_TITLE, this, TextContact.ABOUT_SCREEN_TITLE);

            getAboutScreen().setBounds(DEFAULT_SCREEN_PADDING_LEFT, DEFAULT_SCREEN_PADDING_TOP, Application.WINDOW_WIDTH, Application.WINDOW_HEIGHT);
            this.add(aboutScreen);
            getAboutScreen().setVisible(false);
        }
        return aboutScreen;
    }

    public AnimationManager getAnimationManager() {
        if (animationManager == null) {
            animationManager = new AnimationManager();
        }

        return animationManager;
    }
}