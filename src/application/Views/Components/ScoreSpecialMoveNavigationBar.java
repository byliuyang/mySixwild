package application.Views.Components;

import application.Contracts.TextContact;
import application.Models.Score;
import application.Models.SpecialMoveLeft;
import application.Views.Application;
import application.Views.IModelUpdated;

import java.awt.*;

/**
 *
 */
public class ScoreSpecialMoveNavigationBar extends SpecialMoveNavigationBar implements IModelUpdated {

    //    Left align
    protected final boolean LEFT_ALIGN = true;
    //    Score view text width
    final int SCORE_VIEW_TEXT_WIDTH = 74;
    //    Score view size
    final Dimension SCORE_VIEW_SIZE = new Dimension(200, 58);
    //    Score view font size
    final float SCORE_VIEW_FONT_SIZE = 22l;
    //    Score view integer underline thickness
    final int SCORE_VIEW_UNDERLINE_THICKNESS = 2;
    //    Score view bounds
    final Rectangle SCORE_VIEW_BOUNDS = new Rectangle(78, 0, 200, 58);

    Score score;

    IntegerLabelView scoreView;

    public ScoreSpecialMoveNavigationBar(Application app, SpecialMoveLeft specialMoveLeft, Score score) {
        super(app, specialMoveLeft);

        this.score = score;

        add(getScoreView());
        scoreView.initialize();
    }

    public IntegerLabelView getScoreView() {
        if (scoreView == null) {
            scoreView = new IntegerLabelView(
                    TextContact.SCORE_LABEL_TEXT,
                    score.getCurrentScore(),
                    SCORE_VIEW_UNDERLINE_THICKNESS,
                    SCORE_VIEW_FONT_SIZE,
                    Color.WHITE,
                    LEFT_ALIGN,
                    SCORE_VIEW_TEXT_WIDTH
            );

            scoreView.setPreferredSize(SCORE_VIEW_SIZE);
            scoreView.setMaximumSize(SCORE_VIEW_SIZE);
            scoreView.setMinimumSize(SCORE_VIEW_SIZE);

            scoreView.setBounds(SCORE_VIEW_BOUNDS);
        }
        return scoreView;
    }

    @Override
    public void modelChanged() {
        super.modelChanged();
        scoreView.modelChanged();
    }
}