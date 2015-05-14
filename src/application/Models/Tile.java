package application.Models;

import java.io.Serializable;

/**
 *
 */
public class Tile implements Serializable {


    Value number;
    BonusMultiplier multiplier;

    public Tile(Value number, BonusMultiplier multiplier) {
        this.number = number;
        this.multiplier = multiplier;
    }

    public Value getNumber() {
        return number;
    }

    public void setNumber(Value number) {
        this.number = number;
    }

    public BonusMultiplier getMutiplier() {
        return multiplier;
    }

    public void setMutiplier(BonusMultiplier mutiplier) {
        this.multiplier = mutiplier;
    }
}