package br.eti.balduino.checkers;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private final int row;
    private final int column;
    private final Board board;
    private final Direction direction;

    public Piece(final int row, final int column, final Board board, final Direction direction) {
        this.row = row;
        this.column = column;
        this.board = board;
        this.direction = direction;
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

    public List<Board> getPossibleMovements() {
        List<Board> movements = new ArrayList<>();

        if(column > 0) {
            int newRow = row + direction.getValue();
            int newColumn = column - 1;

            if(board.getAt(newRow, newColumn).getColor() == Color.NONE) {
                movements.add(board.move(row, column, newRow, newColumn));
            } else if (board.getAt(newRow, newColumn).getColor() != getColor()
                    && board.getAt(newRow  + direction.getValue(), newColumn - 1).getColor() == Color.NONE
                    && column > 1) {
                movements.add(board
                                .remove(newRow, newColumn)
                                .move(row, column, newRow + direction.getValue(), newColumn - 1));
            }
        }

        if(column < 7) {
            int newRow = row + direction.getValue();
            int newColumn = column + 1;

            if(board.getAt(newRow, newColumn).getColor() == Color.NONE) {
                movements.add(board.move(row, column, newRow, newColumn));
            }
        }

        return movements;
    }
}
