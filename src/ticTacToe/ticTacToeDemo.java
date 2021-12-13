package ticTacToe;



import javafx.application.Application;
import javafx.stage.Stage;
import ticTacToe.controller.Game;
import ticTacToe.view.OutputFX;

public  class ticTacToeDemo extends Application  {

    public static void main(String[] args) throws Exception {
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
