package SixesWild.Views.Screens.GameScreenPackage;

import SixesWild.Models.Time;
import SixesWild.Views.Components.BufferedCanvas;

/**
 * Created by harryliu on 4/29/15.
 */
public class TimeProgressBar extends BufferedCanvas {
    Time time;

    public TimeProgressBar(Time time) {
        this.time = time;
    }

    @Override
    protected void redrawState() {
        super.redrawState();
    }
}
