package SixesWild.Views.Screens.LevelScreenPackage;

import SixesWild.Models.Levels.Level;
import SixesWild.Views.Components.ListPanel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 */
public class LevelListPanel extends ListPanel {

    ArrayList<Level> levels;

    LevelDetailPanel levelDetailPanel;

    public LevelListPanel(ArrayList<Level> levels, LevelDetailPanel levelDetailPanel) {
        super(levelDetailPanel);
        this.levels = levels;

        setPreferredSize(LIST_PANEL_SIZE);

        setUpViews();
        showViews();

        getViews().get(0).getButton().actived();
        levelDetailPanel.setLevel(levels.get(0));
    }

    @Override
    public void setUpViews() {

        for (Iterator<Level> levelIterator = levels.iterator();levelIterator.hasNext();) {

            Level level = levelIterator.next();

            try {

                LevelView levelView = new LevelView(level, this, levelDetailPanel);

                levelView.setPreferredSize(ListPanel.VIEW_SIZE);
                levelView.setMinimumSize(ListPanel.VIEW_SIZE);
                levelView.setMaximumSize(ListPanel.VIEW_SIZE);

                if (level.isLocked() == true) {
                    levelView.getLevelButton().unlock();
                }

                getViews().add(levelView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}