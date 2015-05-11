package SixesWild.Models;

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
        unlockState = true;
    }

    public void unlock() {
        unlockState =false;
    }

    public boolean isLocked() {
        return unlockState;
    }
}