
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ChessGameTest {


    @Test
    public void testMainB() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3\r\n BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5\r\nRf1\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Rf1: [e1, d1, c1, b1, a1]";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMainK() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3\r\n BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5\r\nKg1\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Kg1: [f1, g2, h1]";
        assertEquals(expectedOutput, out.toString());
    }
    @Test
    public void testMainBishop() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6\r\n BLACK: Kb8, Be8, Pa7, Pb7, Pc7, Ra5\r\nBf5\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Bf5: [e6, d7, c8, e4, d3, c2, b1, g4, h3]";
        assertEquals(expectedOutput, out.toString());
    }
    @Test
    public void testMainKnight() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6\r\n BLACK: Kb8, Be8, Pa7, Pb7, Pc7, Ra5, Rb5, Nd4\r\nNd4\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Nd4: [b3, c6, c2, e6, e2, f3]";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMainQueen() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6\r\n BLACK: Kb8, Be8, Pa7, Pb7, Pc7, Ra5\r\nQf3\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Qf3: [f4, e3, d3, c3, b3, a3, e4, d5, c6, e2, d1, g4, h5, g2, h1]";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMainPawn() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6, Pd6\r\n BLACK: Kb8, Be8, Pa7, Pb7, Pc7, Ra5\r\nPd6\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: LEGAL MOVES FOR Pd6: [d7, c7]";
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMainDD() {
        // Set up input for test
        ByteArrayInputStream in = new ByteArrayInputStream("WHITE: Pd6\r\n BLACK: Ra5\r\nLd6\r\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Call function to test
        Main.main(new String[0]);

        // Check output
        String expectedOutput = "Enter board configuration:\r\nWHITE: BLACK: PIECE TO MOVE: Invalid piece. Please try again.\r\n";
        assertEquals(expectedOutput, out.toString());
    }


    // Test case for computing legal moves for a king
    @Test
    public void testComputeKingMoves() {
        String white = "Rf1, Kg1, Pf2, Ph2, Pg3";
        String black = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
        String piece = "Kg1";
        List<String> expectedMoves = Arrays.asList("g2", "h1");
        assertEquals(expectedMoves, Main.computeKingMoves(white, black, piece));
    }

    // Test case for computing legal moves for a rook
    @Test
    public void testComputeRookMoves() {
        String white = "Rf1, Kg1, Pf2, Ph2, Pg3";
        String black = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
        String piece = "Rf1";
        List<String> expectedMoves = Arrays.asList("e1", "d1", "c1", "b1", "a1");
        assertEquals(expectedMoves, Main.computeRookMoves(white, black, piece.substring(1)));
    }

    @Test
    public void testCheckStraightMoves() {
        String white = "a1 b2 c3 d4 e5 f6 g7 h8";
        String black = "a7 b6 c5 d4 e3 f2 g1";
        int row = 4;
        int col = 4;
        int rowDirection = 1;
        int colDirection = 0;

        List<String> expectedMoves = Arrays.asList("e3");
        List<String> actualMoves = Main.checkStraightMoves(white, black, row, col, rowDirection, colDirection);

        Assertions.assertEquals(expectedMoves, actualMoves);
    }

    // Test case for computing legal moves for a bishop
    @Test
    public void testComputeBishopMoves() {
        String white = "Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6";
        String black = "Kb8, Be8, Pa7, Pb7, Pc7, Ra5";
        String piece = "Bf5";
        List<String> expectedMoves = Arrays.asList("e6", "d7", "c8", "e4", "d3", "c2", "b1", "g4", "h3");
        assertEquals(expectedMoves, Main.computeBishopMoves(white, black, piece.substring(1)));
    }




    // Test case for computing legal moves for a knight
    @Test
    public void testComputeKnightMoves() {
        String white = "Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6";
        String black = "Kb8, Be8, Pa7, Pb7, Pc7, Ra5, Rb5, Nd4";
        String piece = "Nd4";
        List<String> expectedMoves = Arrays.asList("b3", "c6", "c2", "e6", "e2", "f3");
        assertEquals(expectedMoves, Main.computeKnightMoves(white, black, piece.substring(1)));
    }

    // Test case for computing legal moves for a Queen
    @Test
    public void testcomputeQueenMoves() {
        String white = "Rf1, Kg1, Pf2, Ph2, Pg3, Bf5, Rg6";
        String black = "Kb8, Be8, Pa7, Pb7, Pc7, Ra5";
        String piece = "Qf3";
        List<String> expectedMoves = Arrays.asList("f4", "e3", "d3", "c3", "b3", "a3", "e4", "d5", "c6", "e2", "d1", "g4", "h5", "g2", "h1");
        assertEquals(expectedMoves, Main.computeQueenMoves(white, black, piece.substring(1)));
    }

    // Test case for computing legal moves for a Pawn
    @Test
    public void testComputePawnMovesWhite() {
        String white = "a2,b2,c2,d2,e2,f2,g2,h2";
        String black = "a7,b7,c7,d7,e7,f7,g7,h7";
        String piece = "d2";
        List<String> expectedMoves = Arrays.asList("d3", "d4");
        List<String> actualMoves = Main.computePawnMoves(white, black, piece);
        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    public void testComputePawnMovesBlack() {
        String white = "a2,b2,c2,d2,e2,f2,g2,h2";
        String black = "a7,b7,c7,d7,e7,f7,g7,h7";
        String piece = "e7";
        List<String> expectedMoves = Arrays.asList("e6", "e5");
        List<String> actualMoves = Main.computePawnMoves(white, black, piece);
        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    public void testComputePawnMovesNoMoves() {
        String white = "a2,b2,c2,d2,e2,f2,g2,h2";
        String black = "a7,b7,c7,d7,e7,f7,g7,h7";
        String piece = "a2";
        List<String> expectedMoves = Arrays.asList("a3", "a4");
        List<String> actualMoves = Main.computePawnMoves(white, black, piece);
        assertEquals(expectedMoves, actualMoves);
    }

    @Test
    public void testComputePawnMovesCapture() {
        String white = "a2,b2,c2,d2,e2,f2,g2,h2";
        String black = "a7,b7,c7,d7,e7,f7,g7,h7";
        String piece = "a7";
        List<String> expectedMoves = Arrays.asList("a6", "a5");
        List<String> actualMoves = Main.computePawnMoves(white, black, piece);
        assertEquals(expectedMoves, actualMoves);
    }


    @Test
    public void testComputePawnMoves() {
        String white = "a2 b2 c2 d2 e2 f2 g2 h2";
        String black = "a7 b7 c7 d3 e7 f7 g7 h7";
        String piece = "c2";
        List<String> expectedMoves = Arrays.asList("c3", "c4", "d3");
        List<String> actualMoves = Main.computePawnMoves(white, black, piece);
        assertEquals(expectedMoves, actualMoves);
    }



    // This test cases cover the following scenarios:
    // The square is empty
    @Test
    public void testGetOccupantWhenSquareIsEmpty() {
        String square = "e3";
        String white = "a2 b2 c2 d2 e2 f2 g2 h2";
        String black = "a7 b7 c7 d7 e7 f7 g7 h7";
        String expectedOccupant = null;
        String actualOccupant = Main.getOccupant(square, white, black);
        assertEquals(expectedOccupant, actualOccupant);
    }


    // This test cases cover the following scenarios:
    // The square contains a white piece
    @Test
    public void testGetOccupantWhenSquareContainsWhitePiece() {
        String square = "e2";
        String white = "a2 b2 c2 d2 e2 f2 g2 h2";
        String black = "a7 b7 c7 d7 e7 f7 g7 h7";
        String expectedOccupant = "e2";
        String actualOccupant = Main.getOccupant(square, white, black);
        assertEquals(expectedOccupant, actualOccupant);
    }

    // This test cases cover the following scenarios:
    // The square contains a black piece
    @Test
    public void testGetOccupantWhenSquareContainsBlackPiece() {
        String square = "e7";
        String white = "a2 b2 c2 d2 e2 f2 g2 h2";
        String black = "a7 b7 c7 d7 e7 f7 g7 h7";
        String expectedOccupant = "e7";
        String actualOccupant = Main.getOccupant(square, white, black);
        assertEquals(expectedOccupant, actualOccupant);
    }

    // This test cases cover the following scenarios:
    // The square contains both a white and a black piece
    @Test
    public void testGetOccupantWhenSquareContainsBothWhiteAndBlackPiece() {
        String square = "a2";
        String white = "a2 b2 c2 d2 e2 f2 g2 h2";
        String black = "a7 b7 c7 d7 e7 f7 g7 h7";
        String expectedOccupant = "a2";
        String actualOccupant = Main.getOccupant(square, white, black);
        assertEquals(expectedOccupant, actualOccupant);
    }


    // These test cases ensure that the function returns the correct color based on the input piece.
    // The first two test cases check that the function correctly identifies uppercase and lowercase pieces.
    // The next two test cases check that the function works for other pieces.
    @Test
    public void testGetColor() {
        assertEquals('W', Main.getColor("K"));
        assertEquals('B', Main.getColor("p"));
        assertEquals('W', Main.getColor("R"));
        assertEquals('B', Main.getColor("n"));
    }



}