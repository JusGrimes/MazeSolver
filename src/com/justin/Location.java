package com.justin;

public class Location {
    private final int row;

    private final int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) throw new NullPointerException();
        if (obj.getClass() != Location.class) {
            throw new IllegalArgumentException("not the same class");
        }
        Location comp = (Location) obj;

        return row == ((Location) obj).row & col == ((Location) obj).col;
    }
}
