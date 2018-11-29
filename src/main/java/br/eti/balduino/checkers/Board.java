package br.eti.balduino.checkers;

import br.eti.balduino.checkers.pieces.BlackPiece;
import br.eti.balduino.checkers.pieces.WhitePiece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int columns;
    private final Piece[][] board;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private final String setup;

    private void parse(final String setup) {

        Color topColor = Color.NONE;

        for (int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[row].length; column++) {
                switch (setup.charAt(column + (row * 8))) {
                    case 'o':
                    case 'W':
                        if(topColor == Color.NONE) {
                            topColor = Color.WHITE;
                        }

                        board[row][column] = new WhitePiece(row, column, this, topColor == Color.WHITE ? Direction.DOWN : Direction.UP);
                        whitePieces.add(board[row][column]);
                        break;
                    case '#':
                    case 'B':
                        if(topColor == Color.NONE) {
                            topColor = Color.BLACK;
                        }

                        board[row][column] = new BlackPiece(row, column, this, topColor == Color.BLACK ? Direction.DOWN : Direction.UP);
                        blackPieces.add(board[row][column]);
                        break;
                    default:
                        board[row][column] = new NoPiece(row, column, this);
                }
            }
        }
    }

    public Board(final int rows, final int columns, final String setup) {
        assert setup.length() == (rows * columns) : "Setup should have size " + (rows * columns) + " and has " + setup.length();

        this.rows = rows;
        this.columns = columns;
        this.whitePieces = new ArrayList<>();
        this.blackPieces = new ArrayList<>();
        this.board = new Piece[rows][columns];
        this.setup = setup;

        parse(setup);
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public Piece getAt(final int row, final int column) {
        assert row >= 0 : "Row: " + row;
        return (board.clone())[row][column];
    }

    public void println() {
        System.out.println("  | A | B | C | D | E | F | G | H |");
        for(int r = 0; r < rows; r++) {
            System.out.println("--+---+---+---+---+---+---+---+---+");
            System.out.print((r + 1) + " ");
            for(int c = 0; c < columns; c++) {
                System.out.print("| " + getAt(r, c) + " ");
            }
            System.out.println("|");
        }
        System.out.println("--+---+---+---+---+---+---+---+---+\n");
    }

    Board move(int row, int column, int newRow, int newColumn) {
        int currentPosition = (row * 8) + column;
        int newPosition = (newRow * 8) + newColumn;

        char from = setup.charAt(currentPosition);
        char to = setup.charAt(newPosition);

        String newSetup = setup.substring(0, currentPosition) + to + setup.substring(currentPosition + 1);
        newSetup = newSetup.substring(0, newPosition) + from + newSetup.substring(newPosition + 1);

        Board nb = new Board(rows, columns, newSetup);

        return nb;
    }

    Board remove(int row, int column) {
        int position = (row * 8) + column;
        String newSetup = setup.substring(0, position) + Color.NONE + setup.substring(position + 1);

        Board nb = new Board(rows, columns, newSetup);

        return nb;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Board b = (Board)other;
        return (b.setup.equals(setup));
    }

    @Override
    public int hashCode() {
        return setup.hashCode();
    }
}
