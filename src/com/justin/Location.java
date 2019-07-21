package com.justin;

public class Location {
    private final int row;

    private final int col;

    Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int getRow() {
        return row;
    }

    int getCol() {
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

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
