package ticTacToe.view;

import ticTacToe.model.Board;

public class OutputConsole implements Output {


    public void drawMessage() {
        System.out.println("DRAW");
    }

    public void winMessage() {
        System.out.println("YOU WIN");
    }

    public void loseMessage() {
        System.out.println("YOU LOSE");

    }

    public void displayBoard(Board board) {
        System.out.println("============");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board.getBoardTable()[i][j] + " ");
            }
            System.out.println();
        }
    }


}
