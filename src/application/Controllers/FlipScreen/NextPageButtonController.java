package application.Controllers.FlipScreen;

import application.Views.Components.FlipPagePanel;
import application.Views.Components.StyledButton;

import java.awt.event.MouseEvent;

/**
 *
 */
public class NextPageButtonController extends FlipPageButtonController {
    public NextPageButtonController(StyledButton button, FlipPagePanel flipPagePanel) {
        super(button, flipPagePanel);
        if (flipPagePanel.getListPanel().isAtListEnd()) {
            button.disabled();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!flipPagePanel.getListPanel().isAtListEnd()) {
            flipPagePanel.nextPage();

            if (flipPagePanel.getListPanel().isAtListEnd()) {
                button.disabled();
            } else {
                button.enabled();
            }
        }

        if (!flipPagePanel.getListPanel().isAtListHead()) {
            flipPagePanel.getLastPageButton().enabled();
        }
    }
}