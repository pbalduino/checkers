package br.eti.balduino.checkers;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int columns;
    private final Piece[][] board;
    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    private void parse(final String setup) {

        for (int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[row].length; column++) {
                switch (setup.charAt(column + (row * 8))) {
                    case 'W':
                        board[row][column] = new WhitePiece(row, column);
                        whitePieces.add(board[row][column]);
                        break;
                    case 'B':
                        board[row][column] = new BlackPiece(row, column);
                        blackPieces.add(board[row][column]);
                        break;
                    default:
                        board[row][column] = new NoPiece(row, column);
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

        parse(setup);
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public Piece getAt(final int row, final int column) {
        return board[row][column];
    }
    public void println() {
        System.out.println("Board:");
        for(int r = 0; r < rows; r++) {
            System.out.println("+---+---+---+---+---+---+---+---+");
            for(int c = 0; c < columns; c++) {
                System.out.print("| " + getAt(r, c) + " ");
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+---+---+---+---+---+");
    }
}
