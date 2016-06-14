package com.gryglicki.dataStructures;

import java.lang.reflect.Array;

/**
 * Created by Michał Gryglicki, PL on 14.06.2016.
 */
public class Stack<T> {
    private static final int STACK_DEFAULT_SIZE = 128;
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack() {
        stack = (T[]) new Object[STACK_DEFAULT_SIZE];
        top = 0;
    }

    public void push(T elem) {
        stack[++top] = elem;
    }

    public T pop() {
        return stack[top--];
    }

    public T top() {
        return stack[top];
    }
}
