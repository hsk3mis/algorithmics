package com.gryglicki.sorting;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * All merge sort has space complexity of at least O(logN) because of recursion!
 * Variants: reduce space complexity to N/2 and less copying of the second part of the array
 *      => by copying only first half of the array and then merge copy with the second part
 * Some variants of Inplace (O(1) additional space) are not Stable! Some have huge constant factors! Some are quasilinear O(n*log^2(N))!
 *
 * @author Michal Gryglicki, PL
 */

//TODO: Rewrite using ForkJoin framework!
public class MergeSort {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return new ArrayList<>(list);
        }

        ArrayList<Integer> arrayList = new ArrayList<>(list);
        ArrayList<Integer> listToMerge = new ArrayList<>(arrayList);
        sortRecursive(arrayList, 0, arrayList.size() - 1, listToMerge);
        return arrayList;
    }

    private static void sortRecursive(ArrayList<Integer> list, int from, int to, ArrayList<Integer> listToMerge) {
        if (to - from < 1) { //size 1
            return;
        }
        int middle = (to + from) / 2;
        sortRecursive(list, from, middle, listToMerge);
        sortRecursive(list, middle + 1, to, listToMerge);
        merge(list, from, middle, to, listToMerge);
    }

    public static void merge(ArrayList<Integer> list, int from, int middle, int to, ArrayList<Integer> listToMerge) {
        Collections.copy(listToMerge, list);
        int i = from, j = middle + 1;

        for (int k = from; k <= to; k++) {
            if (i <= middle && (j > to || listToMerge.get(i) <= listToMerge.get(j))) {
                list.set(k, listToMerge.get(i));
                i++;
            } else {
                list.set(k, listToMerge.get(j));
                j++;
            }
        }
    }

    public static List<Integer> sortUsingArrays(List<Integer> list) {
        int[] a = Ints.toArray(list);
        a = sort(a);
        return Ints.asList(a);
    }

    public static List<Integer> sortParallel(List<Integer> list) {
        return null;
    }

    public static int[] sort(int[] a) {
        if (a == null) {
            return a;
        }

        int[] toMerge = new int[a.length];
        sortRecursive(a, 0, a.length - 1, toMerge);
        return a;
    }

    private static void sortRecursive(int[] a, int from, int to, int[] toMerge) {
        if (to - from < 1) { //size 1
            return;
        }
        int middle = (to + from) / 2;
        sortRecursive(a, from, middle, toMerge);
        sortRecursive(a, middle + 1, to, toMerge);
        merge(a, from, middle, to, toMerge);
    }

    public static void merge(int[] a, int from, int middle, int to, int[] toMerge) {
        System.arraycopy(a, from, toMerge, from, to - from + 1);
        int i = from, j = middle + 1;

        for (int k = from; k <= to; k++) {
            if (i <= middle && (j > to || toMerge[i] <= toMerge[j])) {
                a[k] = toMerge[i++];
            } else {
                a[k] = toMerge[j++];
            }
        }
    }
}
