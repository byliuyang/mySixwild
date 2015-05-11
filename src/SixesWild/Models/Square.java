package SixesWild.Models;

import java.io.Serializable;

public class Square implements Serializable {

    Location location;
    Tile tile;
    boolean markState;
    boolean containerState;

    public Square() {
        markState = false;
        containerState = false;
    }

    public Square(Location location, Tile tile) {
        this.location = location;
        this.tile = tile;
    }

    public boolean isAdjacent(Square square) {
        return location.isAdjacent(square.getLocation());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isEmpty() {
        if (tile == null) {
            return true;
        }

        return false;
    }

    public boolean isContainer() {
        return containerState;
    }

    public void mark() {
        markState = true;
    }

    public boolean isMarked() {
        return markState;
    }

    public void container() {
        containerState = true;
    }

}