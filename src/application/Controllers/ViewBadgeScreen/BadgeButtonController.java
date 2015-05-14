package application.Controllers.ViewBadgeScreen;

import application.Controllers.FlipScreen.LockableButtonController;
import application.Models.Badge;
import application.Views.Components.LockableButton;
import application.Views.Components.LockableButtonView;
import application.Views.Screens.BadgeScreenPackage.BadgeDetailPanel;
import application.Views.Screens.BadgeScreenPackage.BadgeListPanel;

/**
 * Created by harryliu on 5/4/15.
 */
public class BadgeButtonController extends LockableButtonController {
    Badge badge;
    BadgeDetailPanel badgeDetailPanel;


    public BadgeButtonController(
            LockableButton button,
            BadgeListPanel badgeListPanel,
            LockableButtonView lockableButtonView,
            Badge badge,
            BadgeDetailPanel badgeDetailPanel) {

        super(button, badgeListPanel, lockableButtonView);
        this.badge = badge;
        this.badgeDetailPanel = badgeDetailPanel;
    }
}
