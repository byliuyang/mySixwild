package application.Views.Screens.LevelScreenPackage;

import application.Utilities;
import application.Models.Levels.Level;
import application.Views.Components.ListPanel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class LevelListPanel extends ListPanel {

    ArrayList<Level> levels;

    public LevelListPanel(ArrayList<Level> levels, LevelDetailPanel levelDetailPanel) {
        super(levelDetailPanel);
        this.levels = levels;

        setPreferredSize(LIST_PANEL_SIZE);

        setUpViews();
        showViews();

        setActiveView(getViews().get(0));
        getViews().get(0).getButton().actived();
        levelDetailPanel.setLevel(levels.get(0));
    }

    @Override
    public void setUpViews() {

        getViews().clear();

        for (Iterator<Level> levelIterator = levels.iterator(); levelIterator.hasNext(); ) {

            Level level = levelIterator.next();

            try {

                LevelView levelView = new LevelView(level, this, (LevelDetailPanel) getDetailPanel());

                levelView.setPreferredSize(ListPanel.VIEW_SIZE);
                levelView.setMinimumSize(ListPanel.VIEW_SIZE);
                levelView.setMaximumSize(ListPanel.VIEW_SIZE);

                if (level.isLocked() == false) {
                    levelView.getLevelButton().unlock();
                } else {
                    levelView.getLevelButton().lock();
                }

                levelView.getLevelButton().repaint();

                getViews().add(levelView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unlockLevel(long levelID) {
        levels.get((int) levelID - 1).unlock();

        Utilities.updateLevelState(levels.get((int) levelID - 1));
        setUpViews();
        showViews();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
}