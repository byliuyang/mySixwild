package SixesWild.Models;

import java.io.Serializable;

/**
 *
 */
public class BonusMultiplier implements Serializable {

    Value multiplier;

    public BonusMultiplier(Value multiplier) {
        this.multiplier = multiplier;
    }

    public Value getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Value multiplier) {
        this.multiplier = multiplier;
    }
}