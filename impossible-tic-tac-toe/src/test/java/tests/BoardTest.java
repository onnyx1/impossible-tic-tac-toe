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
        String[][] expResult = {{null, null, null}, {null, null, null}, {null, null, null}};
        assertArrayEquals(instance.getBoard(), expResult);
    }

}
