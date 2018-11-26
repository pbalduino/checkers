package br.eti.balduino.checkers;

import static br.eti.balduino.checkers.Color.BLACK;

public class BlackPiece extends Piece {

    public BlackPiece(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return BLACK;
    }
}
