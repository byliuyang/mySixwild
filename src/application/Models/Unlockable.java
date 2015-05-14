package application.Models;

import java.io.Serializable;

/**
 *
 */
public class Unlockable implements Serializable {

    boolean unlockState;

    public Unlockable(boolean unlockState) {
        this.unlockState = unlockState;
    }

    public void lock() {
        unlockState = false;
    }

    public void unlock() {
        unlockState =true;
    }

    public boolean isLocked() {
        return !unlockState;
    }
}