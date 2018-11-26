package br.eti.balduino.checkers.pieces;

import br.eti.balduino.checkers.Color;
import br.eti.balduino.checkers.Piece;

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
