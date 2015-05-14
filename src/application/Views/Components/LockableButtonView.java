package application.Views.Components;

import javax.swing.*;

/**
 * Created by harryliu on 5/3/15.
 */
public class LockableButtonView extends JPanel {
    LockableButton button;
    ListPanel listPanel;

    public LockableButtonView(ListPanel listPanel) {
        this.listPanel = listPanel;
    }

    public LockableButton getButton() {
        return button;
    }

    public void setButton(LockableButton button) {
        this.button = button;
    }

    public ListPanel getListPanel() {
        return listPanel;
    }
}
