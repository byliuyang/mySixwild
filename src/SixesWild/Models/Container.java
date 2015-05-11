package SixesWild.Models;

import java.io.Serializable;

/**
 * Created by harryliu on 5/6/15.
 */
public class Container extends Square implements Serializable {

    public Container() {
    }

    public Container(Location location, Tile tile) {
        super(location, tile);
    }

    @Override
    public boolean isContainer() {
        return true;
    }
}
