package br.eti.balduino.checkers.pieces;

import br.eti.balduino.checkers.Board;
import br.eti.balduino.checkers.Color;
import br.eti.balduino.checkers.Direction;
import br.eti.balduino.checkers.Piece;

import static br.eti.balduino.checkers.Color.BLACK;

public class BlackPiece extends Piece {

    public BlackPiece(final int row, final int column, final Board board, final Direction direction) {
        super(row, column, board, direction);
    }

    @Override
    public Color getColor() {
        return BLACK;
    }
}
