package br.eti.balduino.checkers;

import static br.eti.balduino.checkers.Color.NONE;

public class NoPiece extends Piece {
    public NoPiece(final int row, final int column, Board board) {
        super(row, column, board, Direction.NONE);
    }

    @Override
    public Color getColor() {
        return NONE;
    }
}
