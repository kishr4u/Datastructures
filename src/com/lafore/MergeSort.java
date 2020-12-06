package com.lafore;

import java.util.ArrayList;

public class MergeSort {
    private long[] theArray; // ref to array theArray
    private int nElems; // number of data items

    //-----------------------------------------------------------
    public MergeSort(int max) // constructor
    {
        theArray = new long[max]; // create array
        nElems = 0;
    }


    /**
     * In merge sort we need additional storage space of N to hold the workspace array. We basically keep partitioning an array then compare
     * the values in the two subarrays and the resultant sorted array is stored in a workspace. In the end the workspace is copied to the main array.
     * We should not use this for in memory sorting as storage space is wasted, better use quick sort.
     *
     * @param workspace
     * @param lower
     * @param upper
     */
    public void recmerge(long[] workspace, int lower, int upper) {


        if (lower == upper) {
            return;
        }
        int mid = lower + upper / 2;

        recmerge(workspace, lower, mid);

        recmerge(workspace, mid + 1, upper);

        merge(workspace, lower, mid + 1, upper);
    }

    private void merge(long[] workspace, int lower, int mid, int upper) {
        int j = 0;
        while (lower < mid && mid < upper + 1) {
            if (theArray[lower] < theArray[mid]) {
                workspace[j++] = theArray[lower++];
            } else {
                workspace[j++] = theArray[mid++];
            }
        }
        while (lower < mid) {
            workspace[j++] = theArray[lower++];

        }
        while (mid < upper + 1) {
            workspace[j++] = theArray[mid++];
        }
        j = lower;
        while (j <= upper) {
            theArray[lower++] = workspace[j];
            j++;
        }
    }


    public void mergeSortRecursion(int first, int last, long[] arr) {
        int mid = (first + last) / 2;
        if (last == first + 1 || last == first) {
            if (arr[first] > arr[last]) {
                long temp = arr[last];
                arr[last] = arr[first];
                arr[first] = temp;
            }
            return;
        }
        mergeSortRecursion(first, mid, arr);

        mergeSortRecursion(mid + 1, last, arr);

        mergeArr(first, mid, last, arr);
    }

    private void mergeArr(int first, int mid, int last, long[] arr) {
        int size = last - first + 1;
        long[] workspace = new long[size];
        int m = mid + 1;
        int f = first;
        int position = 0;

        while (f <= mid && m <= last) {
            if (arr[f] < arr[m]) {
                workspace[position++] = arr[f];
                ++f;
            } else {
                workspace[position++] = arr[m];
                ++m;
            }

        }
        while (f <= mid) {
            workspace[position++] = arr[f];
            ++f;
        }
        while (m <= last) {
            workspace[position++] = arr[m];
            ++m;
        }
        int j = first;
        int p = 0;
        while (j <= last) {
            arr[j++] = workspace[p++];
        }

    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort(100);
        m.theArray = new long[]{3, 2, 5, 6, 7, 1, 9, 8,4,99,79,29,39,11};

        m.mergeSortRecursion(0, m.theArray.length - 1, m.theArray);
        for (long l : m.theArray) {
            System.out.println("FINAL: " + l);
        }
    }


}
