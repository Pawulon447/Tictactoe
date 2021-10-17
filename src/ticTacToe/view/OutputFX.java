package ticTacToe.view;
import ticTacToe.controller.Game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class OutputFX extends Stage implements Output {

    private static int BUTTON_HEIGHT = 150;     //110 jest pierwotne
    private static int BUTTON_WIDTH = 150;

    Game game;
    Button button1 = new Button(" ");
    Button button2 = new Button(" ");
    Button button3 = new Button(" ");
    Button button4 = new Button(" ");
    Button button5 = new Button(" ");
    Button button6 = new Button(" ");
    Button button7 = new Button(" ");
    Button button8 = new Button(" ");
    Button button9 = new Button(" ");

    Stage primaryStage;

    /*
    Stage messageWindow = new Stage();
    Button message=new Button();
    Scene messageScene = new Scene(message);*/
    public OutputFX(Stage primaryStage) {

        this.primaryStage = primaryStage;

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public OutputFX(Game game, Stage primaryStage) {
        this.game = game;
        this.primaryStage = primaryStage;
    }


    public Button getButton(int number){
        switch (number){
            case 1:{
                return button1;
            }
            case 2:{
                return button2;
            }
            case 3:{
                return button3;
            }
            case 4:{
                return button4;
            }
            case 5:{
                return button5;
            }
            case 6:{
                return button6;
            }
            case 7:{
                return button7;
            }
            case 8:{
                return button8;
            }
            case 9:{
                return button9;
            }
        }
        return null;
    }




    public void editButtons(){

        button1.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button2.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button3.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button4.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button5.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button6.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button7.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button8.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        button9.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        applyStyle(button1);
        applyStyle(button2);
        applyStyle(button3);
        applyStyle(button4);
        applyStyle(button5);
        applyStyle(button6);
        applyStyle(button7);
        applyStyle(button8);
        applyStyle(button9);


        GridPane gridPane = new GridPane();
        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);
        gridPane.add(button7, 0, 2, 1, 1);
        gridPane.add(button8, 1, 2, 1, 1);
        gridPane.add(button9, 2, 2, 1, 1);
        //System.out.println(gridPane.button6.text);
        //gridPane.setStyle("-fx-color: #D6ACA3");
        Scene scene = new Scene(gridPane );

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void displayMenu(){
        //playMusic();
        Button buttonSinglePlayer=new Button("single player");
        Button buttonMultiPlayer=new Button("multi player");
        Button buttonExit=new Button("exit game");
        buttonSinglePlayer.setMinSize(110, 50);
        buttonMultiPlayer.setMinSize(110, 50);
        buttonExit.setMinSize(110, 50);
        Stage menu = new Stage();
        GridPane gridPaneMenu = new GridPane();
        gridPaneMenu.add(buttonSinglePlayer, 0, 0, 1, 1);
        gridPaneMenu.add(buttonMultiPlayer,0 , 1, 1, 1);
        gridPaneMenu.add(buttonExit,0 , 2, 1, 1);
        Scene sceneMenu = new Scene(gridPaneMenu);
        menu.setScene(sceneMenu);
        menu.show();
        buttonSinglePlayer.setOnAction(value -> {
            game.run();
            menu.close();
            restartAllButtons();
            return;

            //System.exit(3);
        });
        buttonMultiPlayer.setOnAction(value -> {
            game.setSinglePlayer(false);
            game.run();
            menu.close();
            restartAllButtons();
            return;
            //System.exit(3);
        });
        buttonExit.setOnAction(value -> {
            System.exit(3);
        });
        return;


    }
    public void playMusic(){
        String path = "src\\ticTacToe\\view\\resources\\test.mp3";

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);
        //primaryStage.setTitle("Playing Audio");

    }
    public void playClickSound(){
        String path = "F:\\java\\Duel\\src\\ticTacToe\\view\\resources\\bruh.mp3";

        //Instantiating Media class
        Media clicksound = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer2 = new MediaPlayer(clicksound);

        //by setting this property to true, the audio will be played
        mediaPlayer2.setAutoPlay(true);
        //primaryStage.setTitle("Playing Audio");

    }

    public void winGame(){

    }



    public void applyStyle(Button button){
        button.setStyle("-fx-color: #D6ACA3; -fx-font-size:50 ");
    }


    public void disableAllButtons(){
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }
    public void restartAllButtons(){
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        button1.setText(" ");
        button2.setText(" ");
        button3.setText(" ");
        button4.setText(" ");
        button5.setText(" ");
        button6.setText(" ");
        button7.setText(" ");
        button8.setText(" ");
        button9.setText(" ");


    }

    @Override
    public void drawMessage() {
        //Stage messageWindow = new Stage();
        Stage messageWindow = new Stage();
        Button message=new Button("DRAW");
        Scene messageScene = new Scene(message, 100, 100 );
        messageWindow.setScene(messageScene);
        messageWindow.show();
        message.setOnAction(value -> {
            messageWindow.close();
            game.restartGame();
            //System.exit(2);

            return;


        });
    }
    @Override
    public void winMessage() {
        //Stage messageWindow = new Stage();

        Stage messageWindow = new Stage();
        Button message=new Button("WIN");
        Scene messageScene = new Scene(message, 100, 100 );
        messageWindow.setScene(messageScene);
        messageWindow.show();

        message.setOnAction(value -> {
            messageWindow.close();
            game.restartGame();
            //System.exit(2);

            return;
        });
        //wait();
        //TimeUnit.MINUTES.sleep(1);
    }
    @Override
    public void loseMessage(){
        /*
        Button message=new Button("YOU LOSE");
        Scene scene = new Scene(message, 100, 100 );*/
        Stage messageWindow = new Stage();
        Button message=new Button("YOU LOSE");
        Scene messageScene = new Scene(message, 100, 100 );
        messageWindow.setScene(messageScene);
        messageWindow.show();
        message.setOnAction(value -> {
            messageWindow.close();
            game.restartGame();
            //System.exit(2);

            return ;


        });

    }







/*
    @Override
    public void displayConsoleGame(Board board) {

    }

    @Override
    public void displayFXGame() {

    }*/
}
