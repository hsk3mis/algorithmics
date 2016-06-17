package com.gryglicki.sorting;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.junit.Assert.assertEquals;

/**
 * @author Michal Gryglicki, PL
 */
public class MergeSortTest {

    private Function<List<Integer>, List<Integer>> sortFunction;


    @Before
    public void setUp() {
        sortFunction = MergeSort::sortUsingArrays;
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
    public void sort_sorted_short_odd_list() {
        List<Integer> list = rangeClosed(1, 3).boxed().collect(toList());
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_reversed_short_odd_list() {
        List<Integer> list = reverse(rangeClosed(1, 3).boxed().collect(toList()));
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_sorted_short_even_list() {
        List<Integer> list = rangeClosed(1, 4).boxed().collect(toList());
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_reversed_short_even_list() {
        List<Integer> list = reverse(rangeClosed(1, 4).boxed().collect(toList()));
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Test
    public void sort_random_long_list() {
        Random random = new Random();
        List<Integer> list = random.ints().limit((long) Math.pow(2, 10)).boxed().collect(toList());
        List<Integer> sortedList = sortFunction.apply(list);
        assertSorted(list, sortedList);
    }

    @Ignore("Too long for the normal execution and too much memory uwage >4GB")
    @Test
    public void sort_random_veeeery_long_list() {
        Random random = new Random();
        List<Integer> list = random.ints().limit((long) Math.pow(2, 30)).boxed().collect(toList());
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

    private <T> List<T> reverse(List<T> list) {
        List<T> listToReverse = new ArrayList<>(list);
        Collections.reverse(listToReverse);
        return listToReverse;
    }


}