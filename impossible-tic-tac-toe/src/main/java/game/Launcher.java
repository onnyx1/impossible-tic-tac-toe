package game;

public class Launcher {

    private Board startGame;

    public Launcher() {
        this.startGame = new Board();
    }

    public void play() {

        startGame.createBoard();

        while (true) {

            Board.printBoard(startGame.getBoard());

            if (Board.getWinner(startGame.getBoard()).equals("X") || Board.getWinner(startGame.getBoard()).equals("O")) {
                System.out.println("Player " + Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }
            if (Board.testDraw(startGame.getBoard()).equals("Draw")) {
                System.out.println("It's A Draw!");
                break;
            }

            System.out.println("Player X's Turn");

            int[] coordinatesX = startGame.move();
            startGame.setBoard(Board.doMove(startGame.getBoard(), coordinatesX, "X"));
            Board.printBoard(startGame.getBoard());

            if (Board.getWinner(startGame.getBoard()).equals("X") || Board.getWinner(startGame.getBoard()).equals("O")) {
                System.out.println("Player " + Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }

            if (Board.testDraw(startGame.getBoard()).equals("Draw")) {
                System.out.println("It's A Draw!");
                break;
            }

            System.out.println("Player O's Turn");

            int[] coordinatesO = startGame.move();
            startGame.setBoard(Board.doMove(startGame.getBoard(), coordinatesO, "O"));

        }

    }

}
