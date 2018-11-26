package br.eti.balduino.checkers.pieces;

import br.eti.balduino.checkers.Piece;
import br.eti.balduino.checkers.Color;

import static br.eti.balduino.checkers.Color.WHITE;

public class WhitePiece extends Piece {

    public WhitePiece(int row, int column) {
        super(row, column);
    }

    @Override
    public Color getColor() {
        return WHITE;
    }
}
