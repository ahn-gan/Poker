package com.oocl.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {

    public String playingCards(List<String> pokers) {
//        String[] player1 = pokers
        List<String> player1 = sortAsc(pokers.subList(0, 4));
        List<String> player2 = sortAsc(pokers.subList(4, 9));
//        int result = Compare();
        return "";
    }

    protected List<String> sortAsc(List<String> input) {

        return input.stream().sorted().collect(Collectors.toList());
    }
}
