package ticTacToe;
import javafx.scene.control.Button;
class Field {
    //Button s;

    int coordynatX;
    int coordynatY;

    public Field(int coordynatX, int coordynatY) {
        this.coordynatX = coordynatX;
        this.coordynatY = coordynatY;
    }
    public void putX(Button button){
        button.setOnAction(value ->  {
            button.setText("x");
        });
    }

}
