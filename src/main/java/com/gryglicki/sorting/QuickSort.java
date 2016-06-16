package com.gryglicki.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Michal Gryglicki, PL
 */
public class QuickSort {

    public static List<Integer> qsortWastefully(List<Integer> list) {
        if (list != null && list.size() <= 1) {
            return new ArrayList<>(list);
        } else {
            int pivot = list.get(0);
            List<Integer> smaller = list.stream().filter(x -> x < pivot).collect(toList());
            List<Integer> bigger = list.stream().filter(x -> x > pivot).collect(toList());
            smaller = qsortWastefully(smaller);
            bigger = qsortWastefully(bigger);
            return Stream.concat(Stream.concat(smaller.stream(), Stream.of(pivot)), bigger.stream()).collect(toList());
        }
    }

    //TODO: change return type to be same as input list !!!
    public static List<Integer> qsortInPlace(List<Integer> list) {
        if (list != null && list.size() <= 1) {
            return new ArrayList<>(list);
        } else {
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            _qsortInPlace(arrayList, 0, arrayList.size()-1);
            return arrayList;
        }
    }

    private static void _qsortInPlace(ArrayList<Integer> list, int from, int to) {
        if (to - from + 1 <= 1) {
            return;
        } else {
            int pivotPositionBeforePartition = choosePivot(list, from, to);
            int pivotPositionAfterPartition = partitionInPlace(list, pivotPositionBeforePartition, from, to);
            //Could be written without recursion with the usage of custom internal Stack structure
            _qsortInPlace(list, from, pivotPositionAfterPartition-1);
            _qsortInPlace(list, pivotPositionAfterPartition+1, to);
            return;
        }

    }

    protected static int choosePivot(ArrayList<Integer> list, int from, int to) {
        return from;
    }

    private static int partitionInPlace(List<Integer> list, int pivotIndex, int i, int j) {
        if (pivotIndex != i) { //make sure that pivot is at the beginning (if eg. used non-deterministic pivot finding algorithm)
            swap(list, i, pivotIndex);
            pivotIndex = i;
        }
        Integer pivot = list.get(pivotIndex);
        while (i < j) {
            while (i < j && list.get(i) <= pivot) i++;
            while (list.get(j) > pivot) j--;
            if (i < j) swap(list, i, j);
        }
        swap(list, pivotIndex, j);
        return j;
    }

    private static void swap(List<Integer> list, int i, int j) {
        Integer iElem = list.get(i);
        list.set(i, list.get(j));
        list.set(j, iElem);
    }
}
