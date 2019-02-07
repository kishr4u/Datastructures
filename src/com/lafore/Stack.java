package com.lafore;

/**
 * LIFO
 * we can even use this for reversing a string
 */
public class Stack {

    int max = 100;
    char[] stackArr = new char[max];
    int top = -1;


    public void push(char l) {
        stackArr[++top] = l;
    }

    public char pop() {
        if (!isEmpty())
            return stackArr[top--];
        else
            return 0;

    }

    public char peek() {
        if (!isEmpty())
            return stackArr[top];
        else
            return 0;
    }

    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == max-1);
    }

}

