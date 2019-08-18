package com.oocl.poker;

import java.util.*;

import static com.oocl.poker.Constants.*;
import static java.util.stream.Collectors.toList;

public class Main {

    public String playingPokers(List<String> givenPokers) {
        String result = "";
        List<Poker> pokers = parsePokers(givenPokers);
        List<Poker> player1 = sortPokers(pokers.subList(0, pokers.size() / 2));
        int pokerType1 = getPokersType(player1);
        List<Poker> player2 = sortPokers(pokers.subList(pokers.size() / 2, pokers.size()));
        int pokerType2 = getPokersType(player2);
        if (pokerType1 > pokerType2) {
            result = buildResult(PLAYER1_WIN);
        } else if (pokerType1 == pokerType2){
            switch (pokerType1) {
                case PAIR:
                    result = buildResult(comparePair(player1, player2));
                    break;
                default:
                    result = buildResult(compareSingle(player1, player2));
            }
        } else {
            result = buildResult(PLAYER2_WIN);
        }
        return result;
    }

    private int comparePair(List<Poker> player1, List<Poker> player2) {
        if (player1.get(0).getValue() > player2.get(0).getValue())
            return -1;
        else if (player1.get(0).getValue().equals(player2.get(0).getValue()))
            return 0;
        else
            return 1;
    }

    private int compareSingle(List<Poker> player1, List<Poker> player2) {
        Integer maxPokerValue1 = player1.get(player1.size() - 1).getValue();
        Integer maxPokerValue2 = player2.get(player1.size() - 1).getValue();
        if (maxPokerValue1 > maxPokerValue2) {
            return -1;
        } else if (maxPokerValue1.equals(maxPokerValue2)) {
            if (player1.size() == 1 && player2.size() == 1)
                return 0;
            else
                return compareSingle(player1.subList(0, player1.size() - 1), player2.subList(0, player2.size() - 1));
        } else {
            return 1;
        }
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

    private List<Poker> sortPokers(List<Poker> pokers) {
        return pokers.stream().sorted(Comparator.comparingInt(Poker::getValue)).collect(toList());
    }

    private int getPokersType(List<Poker> pokes) {
        Map<Integer, Integer> pokersMap = getPokersMap(pokes);
        if (isOnePair(pokersMap)) {
            return PAIR;
        } else if (isDoublePairs(pokersMap)) {
            return DOUBLE_PAIR;
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

    private boolean isOnePair(Map<Integer, Integer> pokersMap) {
        return pokersMap.values().stream().filter(value -> value == 2).collect(toList()).size() == 1;
    }

    private boolean isDoublePairs(Map<Integer, Integer> pokersMap) {
        return pokersMap.values().stream().filter(value -> value == 2).collect(toList()).size() == 2;
    }
}
