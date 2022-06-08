package game;

import java.util.Scanner;

public class Board {

    private final int ROWS;
    private final int COLUMNS;

    private String[][] board;
    private Scanner input;

    public Board() {

        this.ROWS = 3;
        this.COLUMNS = 3;
        this.board = new String[ROWS][COLUMNS];
        this.input = new Scanner(System.in);
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLUMNS;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Scanner getInput() {
        return input;
    }

    public String[][] createBoard() {

        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board[row].length; column++) {
                this.board[row][column] = " ";
            }
        }
        return this.board;

    }

    public static String printBoard(String[][] board) {

        String result = "   0 1 2 \n"
                + "   ----- \n"
                + " 0|" + board[0][0] + " " + board[0][1] + " " + board[0][2] + "|" + "\n"
                + " 1|" + board[1][0] + " " + board[1][1] + " " + board[1][2] + "|" + "\n"
                + " 2|" + board[2][0] + " " + board[2][1] + " " + board[2][2] + "|" + "\n"
                + "   -----";

        System.out.println(result);

        return result;

    }

    public int[] move() {

        System.out.print("What is your move's X coordinate?: ");
        int x = Integer.valueOf(input.next());

        System.out.print("What is your move's Y coordinate?: ");
        int y = Integer.valueOf(input.next());

        return new int[]{y, x};

    }

    public static String[][] doMove(String[][] gameBoard, int[] coords, String player) {

        String[][] newBoard = new String[3][3];

        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard[row].length; column++) {
                newBoard[row][column] = gameBoard[row][column];
            }
        }

        if (!(newBoard[coords[0]][coords[1]].equals(" "))) {
            throw new IllegalArgumentException("Can't make move " + "(" + coords[0] + ", " + coords[1] + "), " + "square already taken!");
        }

        newBoard[coords[0]][coords[1]] = player;

        return newBoard;
    }

    public static String getWinner(String[][] board) {

        String[][] winCondition = {{board[0][0], board[0][1], board[0][2]}, {board[1][0], board[1][1], board[1][2]},
        {board[2][0], board[2][1], board[2][2]}, {board[0][0], board[1][0], board[2][0]},
        {board[0][1], board[1][1], board[2][1]}, {board[0][2], board[1][2], board[2][2]},
        {board[0][0], board[1][1], board[2][2]}, {board[0][2], board[1][1], board[2][0]}};

        int winX;
        int winO;
        for (int row = 0; row < winCondition.length; row++) {
            winX = 0;
            winO = 0;
            for (int column = 0; column < winCondition[row].length; column++) {

                if (winCondition[row][column].equals("X")) {
                    winX++;
                }

                if (winCondition[row][column].equals("O")) {
                    winO++;
                }

                if (winX == 3) {
                    return "Computer";
                }

                if (winO == 3) {
                    return "O";
                }

            }
        }

        return "None";

    }

    public static String testDraw(String[][] board) {

        int draw = 0;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals("X") || board[row][column].equals("O")) {
                    draw++;
                }
            }
        }

        if (draw == 9) {
            return "Draw";
        } else {
            return "Playing";
        }

    }

    public static int heuristic_function(String[][] board) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {

                if (board[i][0].equals("X")) {
                    return +5;
                }

                if (board[i][0].equals("O")) {
                    return -5;
                }
            }
        }

        for (int j = 0; j < 3; j++) {

            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {

                if (board[0][j].equals("X")) {
                    return +5;
                }

                if (board[0][j].equals("O")) {
                    return -5;
                }
            }

        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {

            if (board[0][0].equals("X")) {
                return +5;
            }

            if (board[0][0].equals("O")) {
                return -5;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {

            if (board[0][2].equals("X")) {
                return +5;
            }

            if (board[0][2].equals("O")) {
                return -5;
            }
        }

        return 0;

    }

    public static boolean movesRemaining(String[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return true;
                }
            }
        }

        return false;

    }

    public static int miniMax(String[][] board, int depth, Boolean isMaximizer) {

        int outcome = Board.heuristic_function(board);

        if (outcome == 5) {
            return outcome;
        }

        if (outcome == -5) {
            return outcome;
        }

        if (Board.movesRemaining(board) == false) {
            return 0;
        }

        if (isMaximizer == true) {

            int bestValue = -10000000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[i][j].equals(" ")) {

                        board[i][j] = "X";

                        bestValue = Math.max(bestValue, miniMax(board, depth + 1, !isMaximizer));

                        board[i][j] = " ";

                    }
                }
            }
            return bestValue;

        } else {

            int bestValue = 1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board[i][j].equals(" ")) {

                        board[i][j] = "O";

                        bestValue = Math.min(bestValue, miniMax(board, depth + 1, !isMaximizer));

                        board[i][j] = " ";

                    }
                }
            }
            return bestValue;

        }

    }

    public static int[] optimalMove(String[][] board) {

        int bestValue = -10000;

        int[] coords = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j].equals(" ")) {

                    board[i][j] = "X";

                    int value = miniMax(board, 0, false);

                    board[i][j] = " ";

                    if (value > bestValue) {
                        coords[0] = i;
                        coords[1] = j;
                        bestValue = value;

                    }

                }
            }
        }

        return coords;
    }

}
