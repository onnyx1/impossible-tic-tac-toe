package tests;

import game.Board;
import java.util.Scanner;
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

        Board instance = new Board();
        instance.createBoard();
        instance.getBoard()[0][0] = "X";
        instance.getBoard()[0][1] = "O";
        instance.getBoard()[0][2] = "X";

        instance.getBoard()[1][0] = "X";
        instance.getBoard()[1][1] = "X";
        instance.getBoard()[1][2] = "O";

        instance.getBoard()[2][0] = " ";
        instance.getBoard()[2][1] = "X";
        instance.getBoard()[2][2] = "X";

        String result = "   0 1 2 \n"
                + "   ----- \n"
                + " 0|" + "X" + " " + "O" + " " + "X" + "|" + "\n"
                + " 1|" + "X" + " " + "X" + " " + "O" + "|" + "\n"
                + " 2|" + " " + " " + "X" + " " + "X" + "|" + "\n"
                + "   -----";

        assertEquals(Board.printBoard(instance.getBoard()), result);

    }

    /**
     * Test of printBoard method, of class Board.
     */
    @Test
    public void testMove() {

        Board instance = new Board();

        String input = "1\n2";
        instance.setInput(new Scanner(input));
        int[] tuple = instance.move();

        assertTrue(tuple[0] == 1 && tuple[1] == 2);

    }

    @Test
    public void testDoMove() {

        Board instance = new Board();
        instance.createBoard();

        String[][] result = Board.doMove(instance.getBoard(), new int[]{1, 1}, "X");

        assertTrue(result[1][1] == "X");

    }

}
