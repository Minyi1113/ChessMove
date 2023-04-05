# ChessMove

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


Notes

    The input format for the board configuration is a comma-separated list of positions, where each position consists of a piece and its position on the board. The piece is represented by a single uppercase letter, and the position is represented by a lowercase letter indicating the file (a-h) and a digit indicating the rank (1-8). For example, Kd5 represents a white king at position d5.
    The program assumes that the input is valid and does not perform any input validation. Invalid input may cause the program to crash or produce incorrect results.
    The program does not implement any special chess rules, such as castling or en passant. Therefore, the legal moves calculated by the program may not be accurate in certain situations.
    The program has been tested on Java 11 and may not work correctly on older or newer versions of Java.
