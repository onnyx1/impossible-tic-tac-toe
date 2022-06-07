package tests;

import game.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    /**
     * Test of getROWS method, of class Board.
     */
    @Test
    public void testGetRows() {
        Board instance = new Board();
        int result = instance.getRows();
        int expResult = 3;
        assertEquals(expResult, result);
    }

    /**
     * Test of getCOLUMNS method, of class Board.
     */
    @Test
    public void testGetColumns() {
        Board instance = new Board();
        int result = instance.getColumns();
        int expResult = 3;
        assertEquals(expResult, result);
    }

    /**
     * Test of createBoard method, of class Board.
     */
    @Test
    public void testCreateBoard() {
        Board instance = new Board();
        instance.createBoard();
        String[][] expResult = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        assertArrayEquals(instance.getBoard(), expResult);
    }

    /**
     * Test of printBoard method, of class Board.
     */
    @Test
    public void testPrintBoard() {

        Board x = new Board();
        x.createBoard();
        x.getBoard()[0][0] = "X";
        x.getBoard()[0][1] = "O";
        x.getBoard()[0][2] = "X";

        x.getBoard()[1][0] = "X";
        x.getBoard()[1][1] = "X";
        x.getBoard()[1][2] = "O";

        x.getBoard()[2][0] = " ";
        x.getBoard()[2][1] = "X";
        x.getBoard()[2][2] = "X";

        String result = "   0 1 2 \n"
                + "   ------ \n"
                + " 0|" + "X" + " " + "O" + " " + "X" + "|" + "\n"
                + " 1|" + "X" + " " + "X" + " " + "O" + "|" + "\n"
                + " 2|" + " " + " " + "X" + " " + "X" + "|" + "\n"
                + "   ------";
        
        assertEquals(Board.printBoard(x.getBoard()), result);

    }
}
