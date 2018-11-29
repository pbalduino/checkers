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

    private boolean isValidPosition(final int row, final int column) {
        return (row >= 0)
                && (row < board.getRows())
                && (column >= 0)
                && (column < board.getColumns());
    }

    public List<Movement> getPossibleMovements() {
        List<Movement> movements = new ArrayList<>();

        if(column > 0) {
            int newRow = row + direction.getValue();
            int newColumn = column - 1;

            if(isValidPosition(newRow, newColumn)) {
                if (board.getAt(newRow, newColumn).getColor() == Color.NONE) {
                    movements.add(new Movement(row, column, newRow, newColumn, board, false));
                } else if (newColumn > 0
                        && board.getAt(newRow, newColumn).getColor() != getColor()
                        && isValidPosition(newRow + direction.getValue(), newColumn - 1)
                        && board.getAt(newRow + direction.getValue(), newColumn - 1).getColor() == Color.NONE
                ) {
                    movements.add(new Movement(row, column, newRow + direction.getValue(), newColumn - 1, board.remove(newRow, newColumn), true));
                }
            }
        }

        if(column < 7) {
            int newRow = row + direction.getValue();
            int newColumn = column + 1;

            if(isValidPosition(newRow, newColumn)) {
                if (board.getAt(newRow, newColumn).getColor() == Color.NONE) {
                    movements.add(new Movement(row, column, newRow, newColumn, board, false));
                } else if (newColumn < 7
                        && board.getAt(newRow, newColumn).getColor() != getColor()
                        && isValidPosition(newRow + direction.getValue(), newColumn + 1)
                        && board.getAt(newRow + direction.getValue(), newColumn + 1).getColor() == Color.NONE
                ) {
                    movements.add(new Movement(row, column, newRow + direction.getValue(), newColumn + 1, board.remove(newRow, newColumn), true));
                }
            }
        }

        return movements;
    }
}
