package ticTacToe;

/*
1 osobny pakiet logika i model(wzorzec  model view controler)
2 zrobic bota (losowanie znaku i kolejności)
3 input i output powinne byc interfejsami które zastępują działanie System in oraz sout
4 uporządkować metode start
 */


import javafx.application.Application;
import javafx.stage.Stage;
import ticTacToe.controller.Game;
import ticTacToe.view.OutputFX;

public  class ticTacToeDemo extends Application  {

    public static void main(String[] args) throws Exception {

        //game1.start();
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("TictacToe");
        OutputFX outputFX1=new OutputFX(primaryStage);
        outputFX1.playMusic();
        Game game1=new Game(outputFX1);
        game1.showMenu();

    }


}
