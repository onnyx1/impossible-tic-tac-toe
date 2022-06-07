package game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sretc
 */
public class Board {

    private final int ROWS;
    private final int COLUMNS;

    private String[][] board;

    public Board() {

        this.ROWS = 3;
        this.COLUMNS = 3;
        this.board = new String[ROWS][COLUMNS];

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
                      + "   ------ \n"
                      + " 0|" + board[0][0] + " " + board[0][1] + " " + board[0][2] + "|" + "\n"
                      + " 1|" + board[1][0] + " " + board[1][1] + " " + board[1][2] + "|" + "\n"
                      + " 2|" + board[2][0] + " " + board[2][1] + " " + board[2][2] + "|" + "\n"
                      + "   ------";

        System.out.println(result);
        
        return result;
        
    }

}
