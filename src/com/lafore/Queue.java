package com.lafore;

/**
 * LIFO
 * we can even use this for reversing a string
 */
public class Queue {

    int max = 100;
    char[] queueArr = new char[max];
    int top = -1;
    int bottom = 0;



    public void push(char l) {
        if(top == max-1) {
            top  = -1;
        }
        queueArr[++top] = l;
    }

    public char pop() {
        char temp =queueArr[bottom++];
        if (bottom==max){
            bottom=0;

        }
       return  temp;

    }

    public char peek() {
        if (!isEmpty())
            return queueArr[top];
        else
            return 0;
    }

    public boolean isEmpty() // true if stack is empty
    {
        return (top < bottom);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return (top == max-1);
    }

}

