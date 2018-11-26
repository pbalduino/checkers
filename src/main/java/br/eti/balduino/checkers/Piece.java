package br.eti.balduino.checkers;

public abstract class Piece {
    private final int row;
    private final int column;

    public Piece(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return getColor().toString();
    }

    public abstract Color getColor();
}
