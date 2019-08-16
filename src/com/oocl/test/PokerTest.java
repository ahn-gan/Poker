package com.oocl.test;

import com.oocl.main.Poker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerTest {

    @Test
    public void should_player2_win_when_his_pokers_is_single_bigger_than_player1() {
        List<String> pokers = Arrays.asList("5H", "9D", "6C", "2D", "7S", "5C", "3H", "7D", "9C", "10H");
//        String[] player2 = {"5C", "3H", "7D", "9C", "10H"};

        String result = new Poker().playingCards(pokers);

        Assert.assertEquals("player2 win", result);
    }
}
