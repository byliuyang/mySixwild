package application.Views.Screens.LevelScreenPackage;

import application.Models.Levels.Level;
import application.Views.Components.FlipPagePanel;
import application.Views.Components.ListPanel;
import application.Views.Screens.FlipPageScreen;

import java.util.ArrayList;

/**
 * Created by harryliu on 5/3/15.
 */
public class LevelFlipPagePanel extends FlipPagePanel {

    ArrayList<Level> levels;

    public LevelFlipPagePanel(FlipPageScreen flipPageScreen, ArrayList<Level> levels) {
        super(flipPageScreen);
        this.levels = levels;

        getLevelListPanel().setPreferredSize(ListPanel.LIST_PANEL_SIZE);
        getLevelListPanel().setMaximumSize(ListPanel.LIST_PANEL_SIZE);
        getLevelListPanel().setMinimumSize(ListPanel.LIST_PANEL_SIZE);

        getLevelListPanel().setBounds(ListPanel.LIST_PANEL_BOUNDS);
        add(getLevelListPanel());
    }

    public LevelListPanel getLevelListPanel() {
        if (getListPanel() == null) {

            setListPanel(new LevelListPanel(levels, (LevelDetailPanel) getFlipPageScreen().getDetailPanel()));
        }

        return (LevelListPanel) getListPanel();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
}
