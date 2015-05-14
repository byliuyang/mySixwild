package application.Controllers.FlipScreen;

import application.Controllers.ButtonController;
import application.Views.Components.FlipPagePanel;
import application.Views.Components.StyledButton;

/**
 * Created by harryliu on 5/4/15.
 */
public class FlipPageButtonController extends ButtonController {

    FlipPagePanel flipPagePanel;
    boolean reachListEnd;

    public FlipPageButtonController(StyledButton button, FlipPagePanel flipPagePanel) {
        super(button);
        this.flipPagePanel = flipPagePanel;
    }
}
