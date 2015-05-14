package application.Views.Screens.LevelScreenPackage;

import application.Models.Levels.Level;
import application.Views.Application;
import application.Views.Components.DetailPanel;
import application.Views.Screens.FlipPageScreen;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 */
public class LevelsScreen extends FlipPageScreen {

    ArrayList<Level> levels;

    LevelFlipPagePanel levelFlipPagePanel;

    int numberLevels;

    public LevelsScreen(String title, Application app, String navTitle) {

        super(title, app, navTitle);
        numberLevels = 0;
        setUpLevelList();
    }

    void setUpLevelList() {

        levels = new ArrayList<Level>();

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".level");
            }
        };

        numberLevels = new File(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH).listFiles(fileFilter).length;

        for (int i = 1; i <= numberLevels; i++) {

            try {

                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream(System.getProperty(Application.ROOT_PATH)+Application.LEVEL_PATH + "/" + new Integer(i).toString() + ".level")
                );

                Level level = (Level) objectInputStream.readObject();

                levels.add(level);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(levels.size()>0) {

            getLevelDetailPanel().setPreferredSize(DetailPanel.DETAIL_PANEL_SIZE);
            getLevelDetailPanel().setMinimumSize(DetailPanel.DETAIL_PANEL_SIZE);
            getLevelDetailPanel().setMaximumSize(DetailPanel.DETAIL_PANEL_SIZE);

            getLevelDetailPanel().setBounds(DETAIL_PANEL_BOUNDS);
            add(getLevelDetailPanel());

            getLevelFlipPagePanel().setPreferredSize(FLIP_PAGE_PANEL_SIZE);
            getLevelFlipPagePanel().setMinimumSize(FLIP_PAGE_PANEL_SIZE);
            getLevelFlipPagePanel().setMaximumSize(FLIP_PAGE_PANEL_SIZE);

            getLevelFlipPagePanel().setBounds(FLIP_PAGE_PANEL_BOUNDS);
            add(getLevelFlipPagePanel());
            getLevelFlipPagePanel().initialize();
        }

    }

    public LevelDetailPanel getLevelDetailPanel() {
        if (getDetailPanel() == null) {
            setDetailPanel(new LevelDetailPanel(app));
        }

        return (LevelDetailPanel) getDetailPanel();
    }

    public LevelFlipPagePanel getLevelFlipPagePanel() {
        if (levelFlipPagePanel == null) {
            levelFlipPagePanel = new LevelFlipPagePanel(this, levels);
        }

        return levelFlipPagePanel;
    }

    public int getNumberLevels() {
        return numberLevels;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
}