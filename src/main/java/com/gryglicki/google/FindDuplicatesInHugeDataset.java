package com.gryglicki.google;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Michał Gryglicki, PL on 09.06.2016.
 */
public class FindDuplicatesInHugeDataset {

    public static String findDuplicatesInDataset(List<String> dataset) {
        HashMap<String, LinkedList<Integer>> mapOfPrefixes = new HashMap<>();
        for (int i = 0; i< dataset.size(); i++) {
            String prefix = dataset.get(i).substring(0, 5);
            LinkedList<Integer> currentValue = mapOfPrefixes.putIfAbsent(prefix, list(i));
            if (currentValue != null) {
                currentValue.add(i);
                mapOfPrefixes.put(prefix, currentValue);
            }
        }

        List<LinkedList<Integer>> listOfLineNumbersToCheck = mapOfPrefixes.values().stream().filter(lineNumbers -> lineNumbers.size() > 1).collect(Collectors.toList());
        for (LinkedList<Integer> lineNumbers : listOfLineNumbersToCheck) {
            String result = checkIfAnyLinesMatch(lineNumbers, dataset);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private static String checkIfAnyLinesMatch(LinkedList<Integer> lineNumbers, List<String> dataset) {
        HashSet<String> linesSet = new HashSet<>();
        List<String> linesList = lineNumbers.stream().map(i -> dataset.get(i)).collect(Collectors.toList());
        for (String line : linesList) {
            if (! linesSet.add(line)) {
                return line;
            }
        }
        return null;
    }

    public static <T> LinkedList<T> list(T elem) {
        return new LinkedList<>(Arrays.asList(elem));
    }



}
