package SixesWild.Views.Components;

import SixesWild.Models.Time;
import SixesWild.Views.IModelUpdated;

import java.awt.*;

/**
 * Created by harryliu on 4/29/15.
 */
public class TimeProgressBar extends BufferedCanvas implements IModelUpdated {

    //    Background Color
    final Color BACK_COLOR = new Color(86, 116, 92);
    final int TIME_BAR_HEIGHT = 6;
    final int TIME_BAR_ROUND_RADIUS = 6;

    Time time;

    public TimeProgressBar(Time time) {
        this.time = time;
    }

    @Override
    protected void redrawState() {
        super.redrawState();

        int containerWidth = (int) getMinimumSize().getWidth();
        int containerHeight = (int) getMinimumSize().getHeight();

        int paddingTop = (containerHeight - TIME_BAR_HEIGHT) / 2;

//        Draw time progressbar holder
        graphics2D.setColor(BACK_COLOR);
        graphics2D.fillRoundRect(PADDING_LEFT, paddingTop, containerWidth, TIME_BAR_HEIGHT, TIME_BAR_ROUND_RADIUS, TIME_BAR_ROUND_RADIUS);

//        Draw progressbar progress
        double progressWidth = getMinimumSize().getWidth()
                * (((double) time.getEndTime().getValue() - (double) time.getCurrentTime().getValue())
                / (double) time.getEndTime().getValue()
        );
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRoundRect(PADDING_LEFT, paddingTop, (int) progressWidth, TIME_BAR_HEIGHT, TIME_BAR_ROUND_RADIUS, TIME_BAR_ROUND_RADIUS);
    }

    @Override
    public void modelChanged() {
        repaint();
    }

    public Time getTime() {
        return time;
    }
}
