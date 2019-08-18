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
                givenPoker = parsePokerValueWhenHasTJQKA(givenPoker);
                pokers.add(new Poker(Integer.valueOf(givenPoker.substring(0, givenPoker.length() - 1)), givenPoker.substring(givenPoker.length() - 1).charAt(0)));
            });
        }
        return pokers;
    }

    private String parsePokerValueWhenHasTJQKA(String givenPoker) {
        String valueString = givenPoker.substring(0, 1);
        switch (valueString) {
            case "T":
                return givenPoker.replace(valueString, "10");
            case "J":
                return givenPoker.replace(valueString, "11");
            case "Q":
                return givenPoker.replace(valueString, "12");
            case "K":
                return givenPoker.replace(valueString, "13");
            case "A":
                return givenPoker.replace(valueString, "14");
            default:
                return givenPoker;
        }
    }
}
