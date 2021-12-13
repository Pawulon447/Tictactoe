package ticTacToe.model;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    @Test
    public void sprawdzLiczbyDanegoZnakuWWierszachShouldCount() {
        Board board = new Board();
        Assert.assertEquals(1, board.sprawdzLiczbyDanegoZnakuWWierszach('s'));

    }

    @Test
    public void sprawdzCzyWolnePoleChecksIfFieldisEmpty() {
        Board board = new Board();
        board.defaultBoard();
        Assert.assertEquals(true, board.sprawdzCzyWolnePole(2, 1));
    }

    @Test
    public void wylosujLiczbeReturnsRandomNumber() {
        Bot bot = new Bot();
        Assert.assertEquals(10, bot.wylosujLiczbeInt(11));
    }

    @Test
    public void czyZarazWygraszChecksIfPlayerGonnaWin() {
        Bot bot = new Bot();
        Assert.assertEquals(false, bot.czyZarazWygrasz());
    }
}
