package SixesWild.Models;

import java.io.Serializable;

/**
 *
 */
public class Time implements Serializable {

    Value currentTime;

    Value endTime;

    public Time(int endTime) {
        currentTime = new Value(0);
        this.endTime = new Value(endTime);
    }

    public void increase(int amount) {
        if (currentTime.getValue() + amount > endTime.getValue()) {
            currentTime.setValue(endTime.getValue());
        } else {
            currentTime.setValue(currentTime.getValue() + amount);
        }
    }

    public void decrease(int amount) {
        if (currentTime.getValue() - amount < 0) {
            currentTime.setValue(0);
        } else {
            currentTime.setValue(currentTime.getValue() - amount);
        }
    }

    public Value getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Value currentTime) {
        this.currentTime = currentTime;
    }

    public Value getEndTime() {
        return endTime;
    }

    public void setEndTime(Value endTime) {
        this.endTime = endTime;
    }

    public boolean isUsedUp() {
        if (currentTime.getValue() >= endTime.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}