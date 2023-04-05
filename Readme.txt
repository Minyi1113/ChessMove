Chess Move Calculator

This Java program calculates the legal moves for different pieces in chess. It can calculate legal moves for King, Rook, Bishop, Knight, Queen, and Pawn. A simple implementation of a console-based chess game that allows users to enter the initial configuration of the chess board and the piece they want to move. The program then prints the legal moves for that piece.


For example, the input for the above board configuration should look
something like this:
WHITE: Rf1, Kg1, Pf2, Ph2, Pg3
BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5
PIECE TO MOVE: Rf1

Given the above input description, your program should produce the following output:
LEGAL MOVES FOR Rf1: e1, d1, c1, b1, a1

Please note the use of the capital letters K, Q, R, B, N, and P to identify the King, Queen, Rook, Bishop, Knight, and Pawn respectively.



Test cases:

The ChessGameTest class contains several test cases that cover different scenarios. The test cases include:

    testComputeKingMoves: Tests the computeKingMoves method that computes the legal moves for a king.
    testComputeRookMoves: Tests the computeRookMoves method that computes the legal moves for a rook.
    testComputeBishopMoves: Tests the computeBishopMoves method that computes the legal moves for a bishop.
    testComputeKnightMoves: Tests the computeKnightMoves method that computes the legal moves for a knight.
    testComputeQueenMoves: Tests the computeQueenMoves method that computes the legal moves for a queen.
    testComputePawnMoves, testComputePawnMovesBlack, testComputePawnMovesNoMoves, testComputePawnMovesCapture: Tests the computePawnMoves method that computes the legal moves for a pawn.
    testGetOccupantWhenSquareIsEmpty: Tests the getOccupant method that returns the occupant of a square when the square is empty.
    testGetOccupantWhenSquareIsOccupied, testGetOccupantWhenSquareContainsWhitePiece, testGetOccupantWhenSquareContainsBlackPiece, testGetOccupantWhenSquareContainsBothWhiteAndBlackPiece: Tests the getOccupant method that returns the occupant of a square when the square is occupied.
	testGetColor: ensure that the function returns the correct color based on the input piece.


All the test cases pass, and the program is functioning correctly under normal conditions. However, the program may not work correctly under some abnormal conditions, such as when the input is not in the correct format. The program does not handle such cases, and the behavior of the program is undefined when it encounters such situations.




Notes

    The input format for the board configuration is a comma-separated list of positions, where each position consists of a piece and its position on the board. The piece is represented by a single uppercase letter, and the position is represented by a lowercase letter indicating the file (a-h) and a digit indicating the rank (1-8). For example, Kd5 represents a white king at position d5.
    The program assumes that the input is valid and does not perform any input validation. Invalid input may cause the program to crash or produce incorrect results.
    The program does not implement any special chess rules, such as castling or en passant. Therefore, the legal moves calculated by the program may not be accurate in certain situations.
    The program has been tested on Java 11 and may not work correctly on older or newer versions of Java.



