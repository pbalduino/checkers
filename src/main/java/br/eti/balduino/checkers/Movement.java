package br.eti.balduino.checkers;

public class Movement {
    private final int oldRow;
    private final int oldColumn;
    private final int newRow;
    private final int newColumn;
    private final Board originalBoard;
    private final boolean capture;

    public Movement(int oldRow, int oldColumn, int newRow, int newColumn, Board originalBoard, boolean capture) {
        this.oldRow = oldRow;
        this.oldColumn = oldColumn;
        this.newRow = newRow;
        this.newColumn = newColumn;
        this.originalBoard = originalBoard;
        this.capture = capture;
    }

    public Board getOriginalBoard() {
        return originalBoard;
    }

    public Board getNewBoard() {
        return originalBoard.move(oldRow, oldColumn, newRow, newColumn);
    }

    public boolean isCapture() {
        return capture;
    }

    public int getFromRow() {
        return oldRow;
    }

    public int getFromColumn() {
        return oldColumn;
    }

    public int getToRow() {
        return newRow;
    }

    public int getToColumn() {
        return newColumn;
    }
}
