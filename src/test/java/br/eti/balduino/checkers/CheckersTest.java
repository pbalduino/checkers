package br.eti.balduino.checkers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckersTest {

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(8, 8, " W W W WW W W W  W W W W                B B B B  B B B BB B B B ");
    }

    @Test
    @DisplayName("Board should have twelve white pieces")
    public void testBoardHasTwelveWhitePieces() {
        assertEquals(12, board.getWhitePieces().size());
    }

    @Test
    @DisplayName("Board should have twelve black pieces")
    public void testBoardHasTwelveBlackPieces() {
        assertEquals(12, board.getBlackPieces().size());
    }

    @Test
    @DisplayName("Should have only black pieces")
    public void testHasOnlyBlackPieces() {
        for (int row = 5; row < 8; row++) {
            for (int column = 1; column < 8; column += 2) {
                assertEquals(Color.BLACK, board.getAt(row, column - (row % 2)).getColor(), "Expected white piece @ [" + row + ", " + column + "]");
            }
        }
    }

    @Test
    @DisplayName("Should have only white pieces")
    public void testHasOnlyWhitePieces() {
        for (int row = 0; row < 3; row++) {
            for (int column = 1; column < 7; column += 2) {
                assertEquals(Color.WHITE, board.getAt(row, column + (row % 2)).getColor(), "Expected black piece @ [" + row + ", " + column + "]");
            }
        }
    }

    @Test
    @DisplayName("Should have only empty squares")
    public void testHasOnlyEmptySquares() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 7; column += 2) {
                assertEquals(Color.NONE, board.getAt(row, column + (row % 2)).getColor(), "Expected empty @ [" + row + ", " + column + "]");
            }
        }

        for (int row = 5; row < 8; row++) {
            for (int column = 0; column < 7; column += 2) {
                assertEquals(Color.NONE, board.getAt(row, column + (row % 2)).getColor(), "Expected empty square @ [" + row + ", " + column + "]");
            }
        }
    }

    @Test
    @DisplayName("A white piece in the corner has only one possible movement")
    public void testAWhitePieceInTheCornerHasOnlyOnePossibleMovement() {
        Piece piece = board.getAt(2, 7);

        assertEquals(Color.WHITE, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(1, movements.size());
    }

    @Test
    @DisplayName("A white piece in the middle has two possible movements")
    public void testAWhitePieceInTheMiddleHasTwoPossibleMovements() {
        Piece piece = board.getAt(2, 5);

        assertEquals(Color.WHITE, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(2, movements.size());
    }

    @Test
    @DisplayName("A black piece in the corner has only one possible movement")
    public void testABlackPieceInTheCornerHasOnlyOnePossibleMovement() {
        Piece piece = board.getAt(5, 0);

        assertEquals(Color.BLACK, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(1, movements.size());
    }

    @Test
    @DisplayName("A black piece in the middle has two possible movements")
    public void testABlackPieceInTheMiddleHasTwoPossibleMovements() {
        Piece piece = board.getAt(5, 2);

        assertEquals(Color.BLACK, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(2, movements.size());
    }

    @Test
    @DisplayName("A white piece in the middle row doesn't have any possible movements")
    public void testAWhitePieceInTheMiddleRowHasNoPossibleMovements() {
        Piece piece = board.getAt(1, 4);

        assertEquals(Color.WHITE, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(0, movements.size());
    }

    @Test
    @DisplayName("A black piece in the middle row doesn't have any possible movements")
    public void testABlackPieceInTheMiddleRowHasNoPossibleMovements() {
        Piece piece = board.getAt(6, 5);

        assertEquals(Color.BLACK, piece.getColor());

        List<Board> movements = piece.getPossibleMovements();

        assertEquals(0, movements.size());
    }

    @Test
    @DisplayName("White has seven initial possible movements")
    public void testWhiteHasSevenPossibleMovements() {
        List<Piece> whites = board.getWhitePieces();
        List<Board> allMovements = new ArrayList<>();

        for (Piece piece : whites) {
            allMovements.addAll(piece.getPossibleMovements());
        }

        assertEquals(7, allMovements.size());
    }

    @Test
    @DisplayName("Black has seven initial possible movements")
    public void testBlackHasSevenPossibleMovements() {
        List<Piece> blacks = board.getBlackPieces();
        List<Board> allMovements = new ArrayList<>();

        for (Piece piece : blacks) {
            allMovements.addAll(piece.getPossibleMovements());
        }

        assertEquals(7, allMovements.size());
    }

    @Test
    @DisplayName("White captures black")
    public void testWhiteCapturesBlack() {
        board = board
                .move(2, 1, 3, 2)
                .move(5, 0, 4, 1);

        System.out.println("Initial scenario");
        System.out.println("It's WHITE's turn");
        board.println();

        List<Board> movements = board.getAt(3, 2).getPossibleMovements();

        System.out.println(movements.size() + " possible movements");

        int m = 1;
        for(Board movement : movements) {
            System.out.println("\nMovement " + m++);
            movement.println();
        }
    }

    @Test
    @DisplayName("Sample game")
    public void testSampleGame() {

        board.println();

        while(true) {
            System.out.println("White plays");
            List<Board> moves = board.getWhitePieces().get(0).getPossibleMovements();
            List<Board> allMovements = new ArrayList<>();

            for (Piece piece : blacks) {
                allMovements.addAll(piece.getPossibleMovements());
            }

            if(moves.isEmpty()) break;

            System.out.println("Black plays");
            board = moves.get(0);
            board.println();

            moves = board.getBlackPieces().get(0).getPossibleMovements();
            if(moves.isEmpty()) break;

            board = moves.get(0);
            board.println();
        }

    }
}
