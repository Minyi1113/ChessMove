
import java.util.*;
import java.util.logging.Logger;




public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the input board configuration
        System.out.println("Enter board configuration:");
        System.out.print("WHITE: ");
        String white = scanner.nextLine();
        System.out.print("BLACK: ");
        String black = scanner.nextLine();
        System.out.print("PIECE TO MOVE: ");
        String piece = scanner.nextLine();

        String LegalMoves = "LEGAL MOVES FOR ";
        boolean isExit=false;
        // Calling the computeLegalMoves function based on the piece type
        List<String> moves = new ArrayList<>();
        switch (piece.charAt(0)) {
            case 'K':
                moves = computeKingMoves(white, black, piece);
                break;
            case 'R':
                moves = computeRookMoves(white, black, piece.substring(1));
                break;
            case 'B':
                moves = computeBishopMoves(white, black, piece.substring(1));
                break;
            case 'N':
                moves = computeKnightMoves(white, black, piece.substring(1));
                break;
            case 'Q':
                moves = computeQueenMoves(white, black, piece.substring(1));
                break;
            case 'P':
                moves = computePawnMoves(white, black, piece.substring(1));
                break;
            default:
                System.out.println("Invalid piece. Please try again.");
                isExit=true;

        }

        // Print the legal moves for the piece
        if (!isExit) {
            System.out.print(LegalMoves + piece + ": " + moves);}
    }

    //Function to compute legal moves for a King
    public static List<String> computeKingMoves(String white, String black, String piece) {
        List<String> moves = new ArrayList<>();

        // Parse the board configuration strings
        Set<String> whiteSet = parseBoardConfig(white);
        Set<String> blackSet = parseBoardConfig(black);
        String[] pieces = piece.split("");
        String piecePos = pieces[1] + pieces[2];

        // Compute all possible king moves
        int file = piecePos.charAt(0) - 'a';
        int rank = piecePos.charAt(1) - '1';
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    int newFile = file + dx;
                    int newRank = rank + dy;
                    if (newFile >= 0 && newFile < BOARD_SIZE && newRank >= 0 && newRank < BOARD_SIZE) {
                        String newPos = "" + (char) (newFile + 'a') + (char) (newRank + '1');
                        if (!whiteSet.contains(newPos) && !blackSet.contains(newPos)) {
                            moves.add(newPos);
                        }
                    }
                }
            }
        }

        return moves;
    }

    private static Set<String> parseBoardConfig(String config) {
        Set<String> set = new HashSet<>();
        String[] pieces = config.split(", ");
        for (String piece : pieces) {
            String[] parts = piece.split("");
            String pos = parts[1] + parts[2];
            set.add(pos);
        }
        return set;
    }



    public static List<String> computeRookMoves(String white, String black, String piece) {
        int row = 8 - Character.getNumericValue(piece.charAt(1));
        int col = piece.charAt(0) - 'a';

        List<String> moves = new ArrayList<>();

        moves.addAll(checkStraightMoves(white, black, row, col, -1, 0)); // up
        moves.addAll(checkStraightMoves(white, black, row, col, 1, 0)); // down
        moves.addAll(checkStraightMoves(white, black, row, col, 0, -1)); // left
        moves.addAll(checkStraightMoves(white, black, row, col, 0, 1)); // right

        return moves;
    }

    static List<String> checkStraightMoves(String white, String black, int row, int col, int rowDirection, int colDirection) {
        List<String> moves = new ArrayList<>();

        int curRow = row + rowDirection;
        int curCol = col + colDirection;

        while (curRow >= 0 && curRow < 8 && curCol >= 0 && curCol < 8) {
            String target = (char)('a' + curCol) + Integer.toString(8 - curRow);
            if (white.contains(target) || black.contains(target)) {
                if (black.contains(target)) {
                    moves.add(target);
                }
                break;
            } else {
                moves.add(target);
            }

            curRow += rowDirection;
            curCol += colDirection;
        }

        return moves;
    }


    public static List<String> computeBishopMoves(String white, String black, String piece) {
        ArrayList<String> legalMoves = new ArrayList<>();
        int file = piece.charAt(0) - 'a'; // convert file to integer (0-7)
        int rank = 8 - (piece.charAt(1) - '0'); // convert rank to integer (0-7)
        char color = Character.isUpperCase(piece.charAt(0)) ? 'W' : 'B'; // determine color of piece

        // check diagonal moves in each direction
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                int x = file + i;
                int y = rank + j;
                while (x >= 0 && x < 8 && y >= 0 && y < 8) { // while on board
                    String square = "" + (char)('a' + x) + (char)('0' + (8 - y));
                    String occupant = getOccupant(square, white, black);
                    if (occupant == null) { // empty square
                        legalMoves.add(square);

                    } else { // own piece blocks path
                        break; // cannot move past own piece
                    }
                    x += i;
                    y += j;
                }
            }
        }
        return legalMoves;
    }

    // helper method to get the occupant of a square
    public static String getOccupant(String square, String white, String black) {
        String occupant = null;
        if (white.contains(square)) {
            occupant = white.substring(white.indexOf(square), white.indexOf(square) + 2);
        } else if (black.contains(square)) {
            occupant = black.substring(black.indexOf(square), black.indexOf(square) + 2);
        }
        return occupant;
    }

    // helper method to get the color of a piece
    public static char getColor(String piece) {
        return Character.isUpperCase(piece.charAt(0)) ? 'W' : 'B';
    }



    public static List<String> computeKnightMoves(String white, String black, String piece) {
        ArrayList<String> moves = new ArrayList<>();
        int x = piece.charAt(0) - 'a';
        int y = 8 - (piece.charAt(1) - '0');
        int[][] offsets = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};

        for (int[] offset : offsets) {
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 7) {
                String dest = "" + (char)(nx + 'a') + (char)(8 - ny + '0');
                if (!white.contains(dest) && !black.contains(dest)) {
                    moves.add(dest);
                }
            }
        }

        return moves;
    }



    public static List<String> computeQueenMoves(String white, String black, String piece) {
        ArrayList<String> moves = new ArrayList<>();
        moves.addAll(computeRookMoves(white, black, piece));
        moves.addAll(computeBishopMoves(white, black, piece));
        return moves;
    }



    public static List<String> computePawnMoves(String white, String black, String piece) {
        ArrayList<String> moves = new ArrayList<>();
        char file = piece.charAt(0);
        int rank = Character.getNumericValue(piece.charAt(1));
        int direction = (white.contains(piece)) ? 1 : -1; // pawn direction depends on color

        // check for move one square forward
        int nextRank = rank + direction;
        String nextSquare = String.format("%c%d", file, nextRank);
        if (!white.contains(nextSquare) && !black.contains(nextSquare)) {
            moves.add(nextSquare);
        }

        // check for move two squares forward
        if ((direction == 1 && rank == 2) || (direction == -1 && rank == 7)) {
            int nextNextRank = nextRank + direction;
            String nextNextSquare = String.format("%c%d", file, nextNextRank);
            if (!white.contains(nextNextSquare) && !black.contains(nextNextSquare)) {
                moves.add(nextNextSquare);
            }
        }

        // check for capture moves
        char leftFile = (char)(file - 1);
        char rightFile = (char)(file + 1);

        if (leftFile >= 'a') {
            String leftSquare = String.format("%c%d", leftFile, nextRank);
            if (black.contains(leftSquare)) {
                moves.add(leftSquare);
            }
        }

        if (rightFile <= 'h') {
            String rightSquare = String.format("%c%d", rightFile, nextRank);
            if (black.contains(rightSquare)) {
                moves.add(rightSquare);
            }
        }

        return moves;
    }



}
