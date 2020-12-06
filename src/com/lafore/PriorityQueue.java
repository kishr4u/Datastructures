package com.lafore;

/**
 * LIFO
 * we can even use this for reversing a string
 */
public class PriorityQueue {

    int max = 100;
    int[] queueArr = new int[max];
    int nItems = 0;




    public void push(int l) {
        int i=0;
        if(nItems!= max) {
            if (nItems == 0)
                queueArr[nItems++] = l;

            else {

                for (i = nItems - 1; i >= 0; i--) {
                    if (l < queueArr[i]) {
                        queueArr[i + 1] = queueArr[i];
                    } else {
                        break;
                    }

                }
                queueArr[i + 1] = l;
                nItems++;
            }

        }

    }

    public int pop() {
        return queueArr[--nItems];

    }

    public int peek() {
        return queueArr[nItems-1];

    }

    public boolean isEmpty() // true if stack is empty
    {
        return  (nItems==0);
    }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
    {
        return nItems== max;
    }

}

