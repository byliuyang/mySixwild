package application.Views.Screens.BadgeScreenPackage;

import application.Models.Badges.Badge;
import application.Views.Components.FlipPagePanel;
import application.Views.Components.ListPanel;
import application.Views.Screens.FlipPageScreen;

import java.util.ArrayList;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeFlipPagePanel extends FlipPagePanel {
    ArrayList<Badge> badges;

    public BadgeFlipPagePanel(FlipPageScreen flipPageScreen, ArrayList<Badge> badges) {
        super(flipPageScreen);
        this.badges = badges;

        getBadgelListPanel().setPreferredSize(ListPanel.LIST_PANEL_SIZE);
        getBadgelListPanel().setMaximumSize(ListPanel.LIST_PANEL_SIZE);
        getBadgelListPanel().setMinimumSize(ListPanel.LIST_PANEL_SIZE);

        getBadgelListPanel().setBounds(ListPanel.LIST_PANEL_BOUNDS);
        add(getBadgelListPanel());

        initialize();
    }

    public BadgeListPanel getBadgelListPanel() {
        if (getListPanel() == null) {
            setListPanel(new BadgeListPanel(badges, (BadgeDetailPanel) getFlipPageScreen().getDetailPanel()));
        }

        return (BadgeListPanel) getListPanel();
    }
}
