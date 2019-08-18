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

    @Test
    public void should_return_peace_when_all_have_pair_pokers_and_equals_to_peace() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "4C", "4S");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("peace", result);
    }

    @Test
    public void should_return_player1_win_when_his_pokers_has_2_pairs_but_player2_has_1() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "8S", "8C", "4C", "4S", "TC", "QH");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_player2_win_when_all_have_2_pairs_but_player2_bigger_than_player1() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "8S", "8C", "JD", "4C", "4S", "TC", "TH", "2C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_all_have_2_equals_pairs_but_player1_has_bigger_single_one() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "8S", "8C", "JD", "4C", "4S", "8D", "8H", "9C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_player1_win_when_his_pokers_has_3_of_a_kind_but_player1_has_2_pairs() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "4S", "8C", "JD", "TC", "TS", "8D", "8H", "QC");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_player2_win_when_all_have_3_of_a_kind_but_player2_has_bigger_one() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "4S", "8C", "JD", "TC", "TS", "TD", "3H", "5C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_player2_win_when_his_pokers_has_straight_type_but_player1_has_3_of_a_kind() {
        // given
        List<String> pokers = Arrays.asList("4H", "4D", "4S", "8C", "JD", "5C", "6S", "7D", "8H", "9C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player2 win", result);
    }

    @Test
    public void should_return_player1_win_when_both_have_straight_type_but_player1_has_bigger_one() {
        // given
        List<String> pokers = Arrays.asList("8C", "9D", "TS", "JC", "QD", "5C", "6S", "7D", "8H", "9C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }

    @Test
    public void should_return_player1_win_when_his_pokers_is_flush_but_player2_not() {
        // given
        List<String> pokers = Arrays.asList("2C", "9C", "7C", "JC", "AC", "5C", "6S", "7D", "8H", "9C");
        // when
        String result = new Main().playingPokers(pokers);
        // then
        Assert.assertEquals("player1 win", result);
    }
}
