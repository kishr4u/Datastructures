package com.lafore;

public class PriorityQ {

    int max = 100;
    private long[] arr = new long[max];
    int front = -1;


    /**
     * Priority queues are like ordered stack.
     *
     * @param in
     * In the priority-queue implementation we show here, insertion runs in O(N) time,
     * while deletion takes O(1) time.
     */
    public void insert(long in) {

        int i = front;
        while (i >= 0 && arr[i] > in) {
            arr[i + 1] = arr[i];

            i--;
        }
        arr[++i] = in;

        front++;

    }

    public long pop() {
        if(front > -1) {
            return arr[front--];
        }else
            return 0;
    }


    public static  void main(String[] args){
        PriorityQ s = new PriorityQ();
        s.insert(4);
        s.insert(7);
        s.insert(3);
        s.insert(9);
        s.insert(6);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}
