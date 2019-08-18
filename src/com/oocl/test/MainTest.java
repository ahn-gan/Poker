package com.oocl.test;

import com.oocl.poker.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    public void should_player2_win_when_all_have_1_poker_and_his_poker_is_bigger_than_player1() {
        // given
        List<String> pokers = Arrays.asList("5H", "9D");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_player1_win_when_all_have_1_poker_and_his_poker_is_bigger_than_player2() {
        // given
        List<String> pokers = Arrays.asList("AH", "TD");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_player1_win_when_all_have_2_pokers_and_his_pokers_has_pair_but_player2_not() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "TD", "AS");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_player2_win_when_all_have_single_pokers_and_his_max_poker_is_bigger_than_player1() {
        // given
        List<String> pokers = Arrays.asList("TH", "8D", "AD", "2S");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player2 win", result);
    }

//    @Test
//    public void should_player2_win_when_his_pokers_is_single_bigger_than_player1() {
//        List<String> pokers = Arrays.asList("5H", "9D", "6C", "2D", "7S", "5C", "3H", "7D", "9C", "10H");
//        String[] player2 = {"5C", "3H", "7D", "9C", "10H"};

//        String result = new Poker().playingCards(pokers);

//        Assert.assertEquals("player2 win", result);
//    }


//    public String playingCards(List<String> pokers) {
////        String[] player1 = pokers
//        List<String> player1 = sortAsc(pokers.subList(0, 4));
//        List<String> player2 = sortAsc(pokers.subList(4, 9));
////        int result = Compare();
//        return "";
//    }
//
//    protected List<String> sortAsc(List<String> input) {
//
//        return input.stream().sorted().collect(Collectors.toList());
//    }
}
