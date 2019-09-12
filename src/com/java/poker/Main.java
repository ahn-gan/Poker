package com.java.poker;

import java.util.*;

import static com.java.poker.Constants.*;
import static java.util.stream.Collectors.toList;

public class Main {

    public String playingPokers(List<String> givenPokers) {
        String result = "";
        List<Poker> pokers = parsePokers(givenPokers);

        List<Poker> player1 = sortPokers(pokers.subList(0, pokers.size() / 2));
        Map<Integer, Integer> pokersMap1 = getPokersMap(player1);
        int pokerType1 = getPokersType(pokersMap1, player1);

        List<Poker> player2 = sortPokers(pokers.subList(pokers.size() / 2, pokers.size()));
        Map<Integer, Integer> pokersMap2 = getPokersMap(player2);
        int pokerType2 = getPokersType(pokersMap2, player2);

        if (pokerType1 > pokerType2) {
            result = buildResult(PLAYER1_WIN);
        } else if (pokerType1 == pokerType2) {
            switch (pokerType1) {
                case PAIR:
                case DOUBLE_PAIR:
                    result = buildResult(comparePair(pokersMap1, pokersMap2));
                    break;
                case THREE_OF_A_KIND:
                    result = buildResult(compareThree(pokersMap1, pokersMap2));
                    break;
                case STRAIGHT:
                    result = buildResult(compareStraight(player1, player2));
                    break;
                case FULL_HOUSE:
                    result = buildResult(compareFullHouse(pokersMap1, pokersMap2));
                    break;
                case FOUR_OF_A_KIND:
                    result = buildResult(compareFour(pokersMap1, pokersMap2));
                    break;
                case FLUSH:
                default:
                    result = buildResult(compareSingle(player1, player2));
            }
        } else {
            result = buildResult(PLAYER2_WIN);
        }
        return result;
    }

    private int compareFullHouse(Map<Integer, Integer> pokersMap1, Map<Integer, Integer> pokersMap2) {
        int result = compareThree(pokersMap1, pokersMap2);
        return result == PEACE ? comparePair(pokersMap1, pokersMap2) : result;
    }

    private int comparePair(Map<Integer, Integer> player1, Map<Integer, Integer> player2) {
        List<Integer> player1PairsKeys = getKeysKeyFromMapByValue(player1, 2);
        List<Integer> player2PairsKeys = getKeysKeyFromMapByValue(player2, 2);
        int pairsCompareResult = compareList(player1PairsKeys, player2PairsKeys);
        if (pairsCompareResult == 0 && player1.values().contains(1)) {
            List<Integer> player1SingleKeys = getKeysKeyFromMapByValue(player1, 1);
            List<Integer> player2SingleKeys = getKeysKeyFromMapByValue(player2, 1);
            return compareList(player1SingleKeys, player2SingleKeys);
        } else
            return pairsCompareResult;
    }

    private int compareThree(Map<Integer, Integer> pokersMap1, Map<Integer, Integer> pokersMap2) {
        List<Integer> player1PairsKeys = getKeysKeyFromMapByValue(pokersMap1, 3);
        List<Integer> player2PairsKeys = getKeysKeyFromMapByValue(pokersMap2, 3);
        return compareList(player1PairsKeys, player2PairsKeys);
    }

    private int compareFour(Map<Integer, Integer> pokersMap1, Map<Integer, Integer> pokersMap2) {
        List<Integer> player1CompareKeys = getKeysKeyFromMapByValue(pokersMap1, 4);
        List<Integer> player2CompareKeys = getKeysKeyFromMapByValue(pokersMap2, 4);
        return compareList(player1CompareKeys, player2CompareKeys);
    }

    private int compareStraight(List<Poker> player1, List<Poker> player2) {
        return player1.get(0).getValue() > player2.get(0).getValue() ? -1 : (player1.get(0).getValue().equals(player2.get(0).getValue()) ? 0 : 1);
    }

    private int compareList(List<Integer> list1, List<Integer> list2) {
        Integer maxKey1 = list1.get(list1.size() - 1);
        Integer maxKey2 = list2.get(list2.size() - 1);
        if (maxKey1 > maxKey2) {
            return -1;
        } else if (maxKey1.equals(maxKey2)) {
            if (list1.size() == 1)
                return 0;
            else
                return compareList(list1.subList(0, list1.size() - 1), list2.subList(0, list2.size() - 1));
        } else
            return 1;
    }

    private List<Integer> getKeysKeyFromMapByValue(Map<Integer, Integer> map, Integer value) {
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keyList.add(entry.getKey());
            }
        }
        return keyList.stream().sorted().collect(toList());
    }

    private int compareSingle(List<Poker> player1, List<Poker> player2) {
        List<Integer> pokerKey1 = player1.stream().map(Poker::getValue).collect(toList());
        List<Integer> pokerKey2 = player2.stream().map(Poker::getValue).collect(toList());
        return compareList(pokerKey1, pokerKey2);
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

    private int getPokersType(Map<Integer, Integer> pokersMap, List<Poker> originPokers) {
        if (isFullHouse(pokersMap)) {
            return FULL_HOUSE;
        } else if (isOnePair(pokersMap)) {
            return PAIR;
        } else if (isDoublePairs(pokersMap)) {
            return DOUBLE_PAIR;
        } else if (isThreeOfAKind(pokersMap)) {
            return THREE_OF_A_KIND;
        } else if (isStraight(pokersMap.entrySet().stream().map(v -> v.getKey()).collect(toList()))) {
            return STRAIGHT;
        } else if (isFlush(originPokers.stream().map(Poker::getCategory).collect(toList()))) {
            return FLUSH;
        } else if (isFourOfAKind(pokersMap)) {
            return FOUR_OF_A_KIND;
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

    private boolean isThreeOfAKind(Map<Integer, Integer> pokersMap) {
        return pokersMap.values().stream().filter(value -> value == 3).collect(toList()).size() > 0;
    }

    private boolean isStraight(List<Integer> keyList) {
        Integer preKey = null;
        for (int i = 0; i < keyList.size(); i++) {
            if (i == 0) {
                preKey = keyList.get(i);
            } else {
                if (keyList.get(i) == preKey + 1) {
                    preKey = keyList.get(i);
                } else
                    return false;
            }
        }
        return true;
    }

    private boolean isFlush(List<Character> categoryList) {
        Map<Character, Integer> categoryMap = new HashMap<>();
        categoryList.forEach(v -> {
            Integer count = categoryMap.containsKey(v) ? categoryMap.get(v) + 1 : 1;
            categoryMap.put(v, count);
        });
        return categoryMap.keySet().size() == 1;
    }

    private boolean isFullHouse(Map<Integer, Integer> pokersMap) {
        return isOnePair(pokersMap) && isThreeOfAKind(pokersMap);
    }

    private boolean isFourOfAKind(Map<Integer, Integer> pokersMap) {
        return pokersMap.values().stream().filter(value -> value == 4).collect(toList()).size() > 0;
    }
}