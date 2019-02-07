package com.lafore;

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
     * @param workspace
     * @param lower
     * @param upper
     */
    public void recmerge(long[] workspace,int lower, int upper){


        if(lower == upper){
            return;
        }
        int mid = lower+ upper/2;

        recmerge(workspace,lower,mid);

        recmerge(workspace,mid+1,upper);

        merge(workspace,lower,mid+1,upper);
    }

    private void merge(long[] workspace, int lower, int mid, int upper) {
        int j = 0;
        while(lower < mid && mid < upper+1) {
            if (theArray[lower] < theArray[mid]) {
                workspace[j++] = theArray[lower++];
            } else {
                workspace[j++] = theArray[mid++];
            }
        }
        while(lower < mid){
            workspace[j++] = theArray[lower++];

        }
        while (mid< upper+ 1){
            workspace[j++] = theArray[mid++];
        }
        j=lower;
        while(j<=upper){
            theArray[lower++] = workspace[j];
            j++;
        }
    }
}
