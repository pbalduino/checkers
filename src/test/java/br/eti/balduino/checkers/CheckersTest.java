package br.eti.balduino.checkers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckersTest {

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(8, 8, " W W W WW W W W  W W W W                B B B B  B B B BB B B B ");

        board.println();
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
        for(int row = 5; row < 8; row++) {
            for(int column = 1; column < 8; column += 2) {
                assertEquals(Color.BLACK, board.getAt(row, column - (row % 2)).getColor(), "Expected white piece @ [" + row + ", " + column + "]");
            }
        }
    }

    @Test
    @DisplayName("Should have only white pieces")
    public void testHasOnlyWhitePieces() {
        for(int row = 0; row < 3; row++) {
            for(int column = 1; column < 7; column += 2) {
                assertEquals(Color.WHITE, board.getAt(row, column + (row % 2)).getColor(), "Expected black piece @ [" + row + ", " + column + "]");
            }
        }
    }

    @Test
    @DisplayName("Should have only empty squares")
    public void testHasOnlyEmptySquares() {
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 7; column += 2) {
                assertEquals(Color.NONE, board.getAt(row, column + (row % 2)).getColor(), "Expected empty @ [" + row + ", " + column + "]");
            }
        }

        for(int row = 5; row < 8; row++) {
            for(int column = 0; column < 7; column += 2) {
                assertEquals(Color.NONE, board.getAt(row, column + (row % 2)).getColor(), "Expected empty square @ [" + row + ", " + column + "]");
            }
        }
    }

}
