package ticTacToe.model;

import ticTacToe.controller.Game;
import ticTacToe.view.OutputConsole;

import java.util.Arrays;

public class Board  {

    private char[][] boardTable = new char[3][3];
    private char emptyFieldSymbol=' ';

    public char getZnakWolnegoPola() {
        return emptyFieldSymbol;
    }

    Game game1;

    public void setGame1(Game game1) {
        this.game1 = game1;
    }

    public char[][] getBoardTable() {
        return boardTable;
    }
    OutputConsole outputConsole1=new OutputConsole();



    public void fillField(int x, int y,char playerSymbol){
        boardTable[x][y]=playerSymbol;
    }

    public void defaultBoard(){
        System.out.println("============");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                boardTable[i][j]=' ';
            }
            System.out.println();
        }
    }
    public void displayBoard(){
        System.out.println("============");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(boardTable[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean sprawdzCzyWolnePole(int wiersz, int kolumna) {
        if (boardTable[wiersz][kolumna] == emptyFieldSymbol) {
            return true;
        } else {
            return false;
        }

    }

    public int[] sprawdzLiczbyDanegoZnakuWWierszachLubKolumnach(char szukanyZnak) {
        int[] liczbyZnakowWWierszu = new int[boardTable.length];

            for (int wiersz = 0; wiersz < boardTable.length; wiersz++) {
                liczbyZnakowWWierszu[wiersz] = 0;
                for (int kolumna = 0; kolumna < boardTable[wiersz].length; kolumna++) {
                    if (boardTable[wiersz][kolumna] == szukanyZnak) {
                        liczbyZnakowWWierszu[wiersz]++;
                    }
                }

            }
            return liczbyZnakowWWierszu;
    }
    public int[] sprawdzLiczbyDanegoZnakuWWierszach(char szukanyZnak) {
        int[] liczbyZnakowWWierszu = new int[boardTable.length];
        for (int wiersz = 0; wiersz < boardTable.length; wiersz++) {
            liczbyZnakowWWierszu[wiersz] = 0;
            for (int kolumna = 0; kolumna < boardTable.length; kolumna++) {
                if (boardTable[wiersz][kolumna] == szukanyZnak) {
                    liczbyZnakowWWierszu[wiersz]++;
                }
            }

        }
        return liczbyZnakowWWierszu;
    }

    public int sprawdzMaxLiczbeDanegoZnakuWKolumnach(char szukanyZnak) {
        int[] liczbyZnakowWKolumnie = sprawdzLiczbyDanegoZnakuWKolumnach(szukanyZnak);
        Arrays.sort(liczbyZnakowWKolumnie);
        return liczbyZnakowWKolumnie[liczbyZnakowWKolumnie.length - 1];
    }

    public int[] sprawdzLiczbyDanegoZnakuWKolumnach(char szukanyZnak) {
        int[] liczbyZnakowWKolumnie = new int[boardTable.length];
        for (int kolumna = 0; kolumna < boardTable.length; kolumna++) {
            liczbyZnakowWKolumnie[kolumna] = 0;
            for (int wiersz = 0; wiersz < boardTable[0].length; wiersz++) {
                if (boardTable[wiersz][kolumna] == szukanyZnak) {
                    liczbyZnakowWKolumnie[kolumna]++;
                }
            }
        }
        return liczbyZnakowWKolumnie;
    }

    public int sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(char szukanyZnak) {
        int liczbaSzukanychZnakow = 0;
        int kolumna = 0;
        for (int wiersz = boardTable.length - 1; wiersz >= 0; wiersz--) {
            if (boardTable[wiersz][kolumna] == szukanyZnak) {
                liczbaSzukanychZnakow++;
            }
            kolumna++;

        }
        return liczbaSzukanychZnakow;

    }

    public int sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(char szukanyZnak) {
        int liczbaSzukanychZnakow = 0;
        int kolumna = 0;
        for (int wiersz = 0; wiersz < boardTable.length; wiersz++) {
            if (boardTable[wiersz][kolumna] == szukanyZnak) {
                liczbaSzukanychZnakow++;
            }
            kolumna++;
        }
        return liczbaSzukanychZnakow;
    }

    public char podajZnak(int wiersz, int kolumna) {
        return boardTable[wiersz][kolumna];

    }

    public boolean checkWin(char playerSymbol){
        if(check(playerSymbol)){
            winGame(playerSymbol);
            return true;
        }
        if (checkDraw()){
            draw();
            return true;
        }
        return false;
    }

    public boolean checkDraw() {
        char znakWolnegoPola=' ';
        for (int wiersz = 0; wiersz < boardTable.length; wiersz++) {
            for (int kolumna = 0; kolumna < boardTable[wiersz].length; kolumna++) {
                if (boardTable[wiersz][kolumna] == znakWolnegoPola) {
                    return false;
                }
            }

        }
        return true;
    }

    private void draw(){
        outputConsole1.drawMessage();
        game1.disableButtons();
        game1.finishGame("draw");
        //System.exit(3);
    }

    private void winGame(char playerSymbol){
        if(playerSymbol==game1.getPlayerSymbol()){
                game1.disableButtons();
                outputConsole1.winMessage();
                game1.finishGame("win");
            }
        if(playerSymbol==game1.getBotSymbol()){
            game1.disableButtons();
            outputConsole1.loseMessage();
            game1.finishGame("lose");
        }
    }

    private boolean check(char playerSymbol){

        for (int i=0;i<3;i++){
                if(boardTable[i][0]==playerSymbol&&boardTable[i][1]==playerSymbol&&boardTable[i][2]==playerSymbol){
                    return true;
                }
                if(boardTable[0][i]==playerSymbol&&boardTable[1][i]==playerSymbol&&boardTable[2][i]==playerSymbol){
                    return true;
                }
        }
        if(boardTable[0][0]==playerSymbol&&boardTable[1][1]==playerSymbol&&boardTable[2][2]==playerSymbol){
            return true;
        }
        if(boardTable[0][2]==playerSymbol&&boardTable[1][1]==playerSymbol&&boardTable[2][0]==playerSymbol){
            return true;
        }
        return false;

    }

}
