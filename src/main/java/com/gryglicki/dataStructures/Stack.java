package com.gryglicki.dataStructures;

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
        //return stack[top--]; /* Memory leak (not cleaning reference from stack to previous top) */
        T ret = stack[top];
        stack[top] = null;
        top--;
        return ret;
    }

    public T top() {
        return stack[top];
    }
}
