package edu.basic.preparation.data;

/**
 * Data structure with flag and position on the node
 */
public class ListNodePosition {

    public boolean isExists;
    public int pos;

    public ListNodePosition(boolean isExists, int pos) {
        this.isExists = isExists;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return isExists +" : "+ pos;
    }
}
