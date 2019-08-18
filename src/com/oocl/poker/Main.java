package com.oocl.poker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public String playingPokers(List<String> givenPokers) {
        String result = "";
        List<Poker> pokers = parsePokers(givenPokers);
        if (pokers.get(0).getValue() < pokers.get(1).getValue()) {
            result = "player2 win";
        } else if (pokers.get(0).getValue() == pokers.get(1).getValue()) {
            result = "peace";
        } else {
            result = "player1 win";
        }
        return result;
    }

    private List<Poker> parsePokers(List<String> givenPokers) {
        List<Poker> pokers = new ArrayList<>();
        if (!givenPokers.isEmpty()) {
            givenPokers.forEach(givenPoker -> {
                pokers.add(new Poker(Integer.valueOf(givenPoker.substring(0, 1)), givenPoker.charAt(1)));
            });
        }
        return pokers;
    }
}
