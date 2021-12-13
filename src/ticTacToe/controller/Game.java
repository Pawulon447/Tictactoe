package ticTacToe.controller;

import javafx.scene.control.Button;
import ticTacToe.model.Board;
import ticTacToe.model.Bot;
import ticTacToe.view.OutputFX;

import java.util.Random;

public class Game {
    //char playerSymbol='X';
    Board board = new Board();
    OutputFX outputFX1;
    private boolean gameover = false;
    private boolean isSinglePlayer = true;
    //Bot bot1;
    private char playerSymbol;
    private char botSymbol;

    public Game() {

    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setSinglePlayer(Boolean singlePlayer) {
        isSinglePlayer = singlePlayer;
    }

    public char getBotSymbol() {
        return botSymbol;
    }

    Bot bot1 = new Bot(this, board);

    public Game(OutputFX outputFX1) {
        this.outputFX1 = outputFX1;
    }


    public void showMenu() {
        outputFX1.displayMenu();
        outputFX1.setGame(this);
        return;
    }

    public void run() {

        board.defaultBoard();
        board.setGame1(this);


        assignSymbols();
        bot1.setZnakGracza(botSymbol);
        outputFX1.editButtons();
        Random random = new Random();
        boolean a = random.nextBoolean();
        if (a && isSinglePlayer) {
            bot1.wykonajRuch();
            //botMove();
        }
        putSymbol(outputFX1.getButton(1), board, 0, 0);
        putSymbol(outputFX1.getButton(2), board, 0, 1);
        putSymbol(outputFX1.getButton(3), board, 0, 2);
        putSymbol(outputFX1.getButton(4), board, 1, 0);
        putSymbol(outputFX1.getButton(5), board, 1, 1);
        putSymbol(outputFX1.getButton(6), board, 1, 2);
        putSymbol(outputFX1.getButton(7), board, 2, 0);
        putSymbol(outputFX1.getButton(8), board, 2, 1);
        putSymbol(outputFX1.getButton(9), board, 2, 2);


    }

    private void assignSymbols() {
        Random random = new Random();
        boolean a = random.nextBoolean();
        if (a) {
            playerSymbol = 'O';
            botSymbol = 'X';

        } else {
            playerSymbol = 'X';
            botSymbol = 'O';
        }
    }

    public void putSymbol(Button button, Board board, int x, int y) {

        button.setOnAction(value -> {
            button.setText(String.valueOf(playerSymbol));
            button.setDisable(true);
            board.fillField(x, y, playerSymbol);
            board.displayBoard();
            board.checkWin(playerSymbol);
            if (isSinglePlayer) {
                if (board.checkWin(playerSymbol) == false) {
                    bot1.wykonajRuch();
                }
            }
            if (!isSinglePlayer) {
                changePlayerSymbol();
            }

        });
    }

    public void finishGame(String gameOutcome) {
        switch (gameOutcome) {
            case "win": {
                outputFX1.winMessage();
                break;
            }
            case "lose": {
                outputFX1.loseMessage();
                break;
            }
            case "draw": {
                outputFX1.drawMessage();
                break;
            }
            default: {
                System.out.println("invalid game outcome");
                break;
            }
        }
    }

    public void restartGame() {
        board.defaultBoard();

        isSinglePlayer = true;
        showMenu();
    }


    public void disableButtons() {
        outputFX1.disableAllButtons();
    }


    public void botMove2(int x, int y) {
        int buttonNumber = calculateButtonNumber(x, y);
        botFillField(outputFX1.getButton(buttonNumber), x, y);
    }

    public int calculateButtonNumber(int x, int y) {
        return 3 * x + y + 1;
    }


    private void changePlayerSymbol() {
        if (playerSymbol == 'X') {
            playerSymbol = 'O';
        } else {
            playerSymbol = 'X';
        }

    }

    private void botFillField(Button button, int x, int y) {
        button.setText(String.valueOf(botSymbol));
        button.setDisable(true);
        board.fillField(x, y, botSymbol);
        board.displayBoard();
        board.checkWin(botSymbol);

    }


}
