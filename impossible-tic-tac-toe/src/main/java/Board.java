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

        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board[row].length; column++) {
                this.board[row][column] = null;
            }

        }
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public String[][] getBoard() {
        return board;
    }
    
    
    
    
    

}
