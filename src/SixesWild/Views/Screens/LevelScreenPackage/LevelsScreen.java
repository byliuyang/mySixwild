package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.Application;
import SixesWild.Views.Components.DetailPanel;
import SixesWild.Views.Components.ListPanel;
import SixesWild.Views.Screens.FlipPageScreen;

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

    public LevelsScreen(String title, Application app, String navTitle) {

        super(title, app, navTitle);
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

        int numberLevels = new File(System.getProperty(Application.ROOT_PATH) + Application.LEVEL_PATH).listFiles(fileFilter).length;

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
}