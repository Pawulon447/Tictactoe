package ticTacToe.controller;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {


    @Test
    public void calculateButtonNumberShould() {
        Game game = new Game();
        Assert.assertEquals(9, game.calculateButtonNumber(2, 2));
    }
}
