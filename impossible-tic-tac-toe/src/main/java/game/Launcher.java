package game;

import java.util.Random;

public class Launcher {

    private Board startGame;

    public Launcher() {
        this.startGame = new Board();
    }

    public void play() {

        boolean firstMove = false;
        startGame.createBoard();

        while (true) {

            Board.printBoard(startGame.getBoard());

            if (Board.getWinner(startGame.getBoard()).equals("O")) {
                System.out.println("Player " + Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }

            if (Board.getWinner(startGame.getBoard()).equals("Computer")) {
                System.out.println(Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }

            if (Board.testDraw(startGame.getBoard()).equals("Draw")) {
                System.out.println("It's A Draw!");
                break;
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Computer's Turn");

            if (firstMove == false) {
                Random ran = new Random();
                startGame.setBoard(Board.doMove(startGame.getBoard(), new int[]{ran.nextInt(3), ran.nextInt(3)}, "X"));
                firstMove = true;
            } else {
                startGame.setBoard(Board.doMove(startGame.getBoard(), Board.optimalMove(startGame.getBoard()), "X"));
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Board.printBoard(startGame.getBoard());

            if (Board.getWinner(startGame.getBoard()).equals("O")) {
                System.out.println("Player " + Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }

            if (Board.getWinner(startGame.getBoard()).equals("Computer")) {
                System.out.println(Board.getWinner(startGame.getBoard()) + " Wins!");
                break;
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Player O's Turn");

            int[] coordinatesO = startGame.move();

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            startGame.setBoard(Board.doMove(startGame.getBoard(), coordinatesO, "O"));

        }

    }

}
