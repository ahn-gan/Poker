package com.oocl.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.oocl.poker.Constants.*;

public class Main {

    public String playingPokers(List<String> givenPokers) {
        String result = "";
        List<Poker> pokers = parsePokers(givenPokers);
        List<Poker> player1 = pokers.subList(0, pokers.size() / 2);
        int pokerType1 = getPokersType(player1);
        List<Poker> player2 = pokers.subList(pokers.size() / 2, pokers.size());
        int pokerType2 = getPokersType(player2);
        if (pokerType1 == PAIR && pokerType2 == SINGLE) {
            result = buildResult(PLAYER1_WIN);
        } else if (pokerType1 == SINGLE && pokerType2 == PAIR) {
            result = buildResult(PLAYER2_WIN);
        } else {
            // both single
            if (player1.get(0).getValue() < player2.get(0).getValue()) {
                result = "player2 win";
            } else if (player1.get(0).getValue().equals(player2.get(0).getValue())) {
                result = "peace";
            } else {
                result = "player1 win";
            }
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


    private int getPokersType(List<Poker> pokes) {
        Map<Integer, Integer> pokersMap = getPokersMap(pokes);
        int maxSamePokerValue = pokersMap.values().stream().mapToInt(v -> v).max().getAsInt();
        if (maxSamePokerValue == 2) {
            return PAIR;
        }
        return SINGLE;
    }

    private Map<Integer, Integer> getPokersMap(List<Poker> pokes) {
        Map<Integer, Integer> pokersMap = new HashMap<>();
        pokes.forEach(poker -> {
            Integer samePokerValueCount = pokersMap.containsKey(poker.getValue()) ? pokersMap.get(poker.getValue()) + 1 : 1;
            pokersMap.put(poker.getValue(), samePokerValueCount);
        });
        return pokersMap;
    }

    private String buildResult(int result) {
        return result == PLAYER1_WIN ? "player1 win" : (result == PEACE ? "peace" : "player2 win");
    }
}
