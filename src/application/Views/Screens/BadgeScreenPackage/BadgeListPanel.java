package application.Views.Screens.BadgeScreenPackage;

import application.Models.Badges.Badge;
import application.Views.Components.ListPanel;

import java.util.ArrayList;

/**
 *
 */
public class BadgeListPanel extends ListPanel {

    ArrayList<Badge> badges;

    BadgeDetailPanel badgeDetailPanel;

    public BadgeListPanel(ArrayList<Badge> badges, BadgeDetailPanel badgeDetailPanel) {
        super(badgeDetailPanel);
        this.badges = badges;
        this.badgeDetailPanel = badgeDetailPanel;
    }

    @Override
    public void setUpViews() {

//        for (Iterator<Badges> badge = badges.iterator(); badge.hasNext();) {
//            LevelView levelView = new LevelView(level.next(), levelDetailPanel);
//            levelView.setPreferredSize(ListPanel.VIEW_SIZE);
//
//            getViews().add(levelView);
//        }


        for (int i = 0; i < 16; i++) {

            BadgeView badgeView = new BadgeView(null, this, badgeDetailPanel);

            badgeView.setPreferredSize(ListPanel.VIEW_SIZE);
            badgeView.setMinimumSize(ListPanel.VIEW_SIZE);
            badgeView.setMaximumSize(ListPanel.VIEW_SIZE);

            if (i % 2 == 0) {
                badgeView.getBadgeButton().unlock();
            }

            getViews().add(badgeView);
        }

    }
}