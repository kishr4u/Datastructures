package com.lafore;

public class BinarySearchOrderedArray {

    private int[] a = new int[100];
    public int[][] i = {{1, 1}, {2, 2}};//unused
    int position = 0;

    //O(n)
    public void insert(int n) {
        int pos = 0;
        if (position < a.length) {

            for (int s = 0; s < a.length; s++) {
                if (a[s] > n) {
                    pos = s;
                }
                break;
            }

            for (int i = position; i > pos; i--) {
                a[i] = a[i - 1];
            }
            a[pos] = n;
            position++;
        }
    }

    //o(logn)
    public static boolean binarySearch(int n) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int start = 0, end = a.length - 1;

        while (true) {
            int pos = (start + end) / 2;
            System.out.println("Start, end, i : " + start + "," + end + "," + pos);
            if (n == a[pos]) {
                System.out.println("pos =" + pos);
                return true;

            } else if (start >= end) {
                System.out.println("notfound =" + pos);
                return false;
            } else {
                if (n > a[pos]) {
                    start = pos + 1;

                } else if (n < a[pos]) {
                    end = pos - 1;
                }
            }

        }

    }

    //o(logn)
    public static boolean binarySearchRecursion(int[] a, int n, int start, int end) {



        int pos = (start + end) / 2;

        if (n == a[pos]) {
            System.out.println("pos =" + pos);
            return true;

        } else if (start >= end) {
            System.out.println("notfound =" + pos);
            return false;
        } else {
            if (n > a[pos]) {
                binarySearchRecursion(a,n, pos + 1, end);


            } else if (n < a[pos]) {
                binarySearchRecursion(a,n, start, pos - 1);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        int start = 0;
        int end = a.length - 1;
        binarySearchRecursion(a,6,start,end);
    }


    //O(n)
    public boolean search(int s) {
        int i = 0;
        int k = 0;
        boolean found = false;
        for (; i < a.length; i++) {
            if (a[i] == (s)) {
                found = true;
                break;

            }
        }
        return found;

    }
}
