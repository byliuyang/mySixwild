package application.Moves;

import application.Models.*;
import application.Models.Levels.Level;
import application.Models.Levels.LightningLevel;
import application.Utilities;
import application.Views.Application;

import java.util.Random;
import java.util.Timer;

/**
 * Created by harryliu on 5/6/15.
 */
public class RestartLevelMove implements IMove {

    Level level;

    public RestartLevelMove(Level level) {
        this.level = level;
    }

    @Override
    public boolean isValid() {

        boolean validation = true;
        return validation;
    }

    @Override
    public boolean doMove(Application app) {
        if (isValid()) {
            Square[][] squares = level.getGrid().getSquares();
            Probabilities probabilities = level.getGrid().getProbabilities();

            for (int row = 0; row < Grid.MAX_ROWS; row++) {
                for (int column = 0; column < Grid.MAX_COLUMNS; column++) {
                    if (squares[row][column] != null) {

                        Tile tile = null;

                        if (!squares[row][column].isContainer()) {
                            //                    Generate multiplier
                            BonusMultiplier multiplier = null;

                            Random random = new Random();
                            int randomInt = random.nextInt(Utilities.ONE_HUNDRED);
                            if (randomInt <= probabilities.getMultiplierOne().getValue()) {
                                multiplier = new BonusMultiplier(new Value(Utilities.ONE));

                            } else if (randomInt > probabilities.getMultiplierOne().getValue()
                                    && randomInt <= probabilities.getMultiplierTwo().getValue()) {

                                multiplier = new BonusMultiplier(new Value(Utilities.TWO));

                            } else if (randomInt > probabilities.getMultiplierTwo().getValue()
                                    && randomInt <= probabilities.getMultiplierThree().getValue()) {
                                multiplier = new BonusMultiplier(new Value(Utilities.THREE));
                            }

//                    Generate tile

                            random = new Random();
                            randomInt = random.nextInt(Utilities.ONE_HUNDRED);

                            if (randomInt <= probabilities.getTileOne().getValue()) {

                                tile = new Tile(new Value(Utilities.ONE), multiplier);

                            } else if (randomInt > probabilities.getTileOne().getValue()
                                    && randomInt <= probabilities.getTileTwo().getValue()) {

                                tile = new Tile(new Value(Utilities.TWO), multiplier);

                            } else if (randomInt > probabilities.getTileTwo().getValue()
                                    && randomInt <= probabilities.getTileThree().getValue()) {

                                tile = new Tile(new Value(Utilities.THREE), multiplier);

                            } else if (randomInt > probabilities.getTileThree().getValue()
                                    && randomInt <= probabilities.getTileFour().getValue()) {

                                tile = new Tile(new Value(Utilities.FOUR), multiplier);

                            } else if (randomInt > probabilities.getTileFour().getValue() && randomInt <= probabilities.getTileFive().getValue()) {

                                tile = new Tile(new Value(Utilities.FIVE), multiplier);
                            } else if (randomInt > probabilities.getTileFive().getValue() && randomInt <= probabilities.getTileSix().getValue()) {

                                tile = new Tile(new Value(Utilities.SIX), multiplier);
                            }
                        } else {
                            tile = null;
                        }

                        squares[row][column].setTile(tile);

                    }
                }
            }

            if (level instanceof LightningLevel) {
                if (app.getGameScreen().getTimer() != null) {

                    app.getGameScreen().getTimer().cancel();

                    ((LightningLevel) level).getTime().setCurrentTime(Utilities.ZERO);

                    Timer timer = new Timer();
                    app.getGameScreen().setTimer(timer);
                    timer.scheduleAtFixedRate(new TimerAutoMove(app, level, ((LightningLevel) level).getTime()), Utilities.ONE_SECOND, Utilities.ONE_SECOND);
                }
            }

            level.getScore().setCurrentScore(0);

            app.getGameScreen().getRestartLevelSpecialMoveSound().play();

            return true;
        } else {
            return false;
        }
    }
}
