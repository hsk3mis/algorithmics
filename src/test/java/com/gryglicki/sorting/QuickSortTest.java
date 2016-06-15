package com.gryglicki.sorting;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

/**
 * @author Michal Gryglicki, PL
 */
public class QuickSortTest {

    private Function<List<Integer>, List<Integer>> sortFunction;

    @Before
    public void setUp() {
        //sortFunction = QuickSort::qsortWastefully;
        sortFunction = QuickSort::qsortInPlace;
    }

    @Test
    public void sort_empty_list() {
        List<Integer> list = Lists.newArrayList();
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_singleElement_list() {
        List<Integer> list = Lists.newArrayList(1);
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_sorted_list() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_reversed_list() {
        List<Integer> list = Lists.newArrayList(3, 2, 1);
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_random_list() {
        Random random = new Random();
        List<Integer> list = random.ints().limit(100).boxed().collect(toList());
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    private <T extends Comparable<? super T>> void assertSorted(List<T> initial, List<T> potentiallySorted) {
        assertEquals(sortYouCanTrust(initial), potentiallySorted);
    }

    private <T extends Comparable<? super T>> List<T> sortYouCanTrust(List<T> list) {
        List<T> listToSort = new ArrayList<>(list);
        Collections.sort(listToSort);
        return listToSort;
    }


}