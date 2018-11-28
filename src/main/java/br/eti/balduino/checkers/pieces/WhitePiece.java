package br.eti.balduino.checkers.pieces;

import br.eti.balduino.checkers.Board;
import br.eti.balduino.checkers.Direction;
import br.eti.balduino.checkers.Piece;
import br.eti.balduino.checkers.Color;

import static br.eti.balduino.checkers.Color.WHITE;

public class WhitePiece extends Piece {

    public WhitePiece(final int row, final int column, final Board board, final Direction direction){
        super(row, column, board, direction);
    }

    @Override
    public Color getColor() {
        return WHITE;
    }
}
