package application.Controllers.FlipScreen;

import application.Controllers.ButtonController;
import application.Views.Components.ListPanel;
import application.Views.Components.LockableButton;
import application.Views.Components.LockableButtonView;

import java.awt.event.MouseEvent;

/**
 * Created by harryliu on 5/3/15.
 */
public class LockableButtonController extends ButtonController {

    ListPanel listPanel;
    LockableButtonView lockableButtonView;

    public LockableButtonController(LockableButton button, ListPanel listPanel, LockableButtonView lockableButtonView) {
        super(button);
        this.listPanel = listPanel;
        this.lockableButtonView = lockableButtonView;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        LockableButtonView activeView = listPanel.getActiveView();
        if (activeView != null) {
            listPanel.getActiveView().getButton().inactive();
            listPanel.getActiveView().getButton().normal();
        }

        listPanel.setActiveView(lockableButtonView);
        button.actived();
    }
}
