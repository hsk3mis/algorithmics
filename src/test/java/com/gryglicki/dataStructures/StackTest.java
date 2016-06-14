package com.gryglicki.dataStructures;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Michał Gryglicki, PL on 14.06.2016.
 */
public class StackTest {
    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void pop_from_empty_stack_should_return_null() {
        assertEquals(null, stack.pop());
    }

    @Test
    public void pop_should_return_pushed_element() {
        //given
        String elem = "abc";
        stack.push(elem);
        //when
        String popedElem = stack.pop();
        //then
        assertEquals(elem, popedElem);
    }

    @Test
    public void pops_should_return_pushed_elements_in_reverse_order() {
        //given
        String[] elems = {"abc", "def", "ghi"};
        Arrays.stream(elems).forEach(elem -> stack.push(elem));
        //when
        List<String> popedElems = Stream.generate(() -> stack.pop()).limit(elems.length).collect(toList());
        //then
        assertTrue(Iterables.elementsEqual(Arrays.asList(elems), Lists.reverse(popedElems)));
    }

    @Test
    public void top_from_empty_stack_should_return_null() {
        assertEquals(null, stack.top());
    }

    @Test
    public void top_should_return_last_pushed_element_without_removing_it() {
        //given
        String elem1 = "abc";
        String elem2 = "def";
        stack.push(elem1);
        stack.push(elem2);
        //when-then
        assertEquals(elem2, stack.top());
        assertEquals(elem2, stack.top());
    }

}