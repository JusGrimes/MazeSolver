package com.justin;

public enum State {
    BLOCKED('X'),
    OPEN (' '),
    PATH ('*'),
    START ('S'),
    GOAL ('G');

    private char glyph;

    State(char glyph) {
        this.glyph = glyph;
    }

    public char getGlyph() {
        return glyph;
    }
}
