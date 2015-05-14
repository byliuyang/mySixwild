package application.Views.Components;

import application.Contracts.TextContact;
import application.Models.Score;
import application.Models.SpecialMoveLeft;
import application.Models.Time;
import application.Models.Value;
import application.Views.Application;
import application.Views.IModelUpdated;

import java.awt.*;

/**
 * Created by harryliu on 5/7/15.
 */
public class LevelTimeRemainNavigationBar extends ScoreSpecialMoveNavigationBar implements IModelUpdated {

    //    Time label size
    final Dimension TIME_LABEL_SIZE = new Dimension(50, 24);
    //    Time label font size
    final float TIME_LABEL_FONT_SIZE = 16l;

    final boolean LEFT_ALIGN = true;

    //    Number view bounds
    final Rectangle TIME_LABEL_BOUNDS = new Rectangle(320, 29, 50, 24);

    //    Padding left
    final int PADDING_LEFT = 0;

    //    Level view text width
    final int LEVEL_VIEW_TEXT_WIDTH = 54;
    //    Level view size
    final Dimension LEVEL_VIEW_SIZE = new Dimension(150, 24);
    //    Level view font size
    final float LEVEL_VIEW_FONT_SIZE = 16l;
    //    Level view integer underline thickness
    final int LEVEL_VIEW_UNDERLINE_THICKNESS = 1;

    //    Level view bounds
    final Rectangle LEVEL_VIEW_BOUNDS = new Rectangle(320, 5, 150, 24);

    //    Time progress bar size
    final Dimension TIME_PROGRESS_BAR_SIZE = new Dimension(460, 24);

    //    Time progress bar bounds
    final Rectangle TIME_PROGRESS_BAR_BOUNDS = new Rectangle(370, 32, 460, 24);

    Time time;
    TimeProgressBar timeProgressBar;
    IntegerLabelView LevelNumberView;
    Value levelNumber;

    public LevelTimeRemainNavigationBar(Application app, SpecialMoveLeft specialMoveLeft, Score score, Time time, Value levelNumber) {
        super(app, specialMoveLeft, score);
        this.time = time;
        this.levelNumber = levelNumber;

        initialize();
    }

    private void initialize() {
        StyledLabel label = new StyledLabel(TextContact.TIME_REMAIN_LABEL_TEXT, TIME_LABEL_FONT_SIZE, Color.WHITE, LEFT_ALIGN);
        label.setPreferredSize(TIME_LABEL_SIZE);
        label.setMaximumSize(TIME_LABEL_SIZE);
        label.setMinimumSize(TIME_LABEL_SIZE);
        label.setBounds(TIME_LABEL_BOUNDS);
        add(label);
        label.repaint();

        add(getLevelNumberView());
        getLevelNumberView().initialize();

        add(getTimeProgressBar());
        getTimeProgressBar().repaint();
    }

    public TimeProgressBar getTimeProgressBar() {
        if (timeProgressBar == null) {
            timeProgressBar = new TimeProgressBar(time);

            timeProgressBar.setPreferredSize(TIME_PROGRESS_BAR_SIZE);
            timeProgressBar.setMaximumSize(TIME_PROGRESS_BAR_SIZE);
            timeProgressBar.setMinimumSize(TIME_PROGRESS_BAR_SIZE);

            timeProgressBar.setBounds(TIME_PROGRESS_BAR_BOUNDS);
        }

        return timeProgressBar;
    }

    public IntegerLabelView getLevelNumberView() {
        if (LevelNumberView == null) {
            LevelNumberView = new IntegerLabelView(
                    TextContact.LEVEL_ID,
                    levelNumber,
                    LEVEL_VIEW_UNDERLINE_THICKNESS,
                    LEVEL_VIEW_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN,
                    LEVEL_VIEW_TEXT_WIDTH
            );

            LevelNumberView.setPreferredSize(LEVEL_VIEW_SIZE);
            LevelNumberView.setMaximumSize(LEVEL_VIEW_SIZE);
            LevelNumberView.setMinimumSize(LEVEL_VIEW_SIZE);

            LevelNumberView.setBounds(LEVEL_VIEW_BOUNDS);
        }
        return LevelNumberView;
    }

    @Override
    public void modelChanged() {
        super.modelChanged();
        getLevelNumberView().modelChanged();
        getTimeProgressBar().modelChanged();
    }
}
