package br.eti.balduino.checkers;

public enum Direction {
    UP(-1),
    NONE(0),
    DOWN(1);

    private int value;

    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
