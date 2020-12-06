package com.lafore;

/**
 * Quick sort again splits the array into a two based on a pivotal and then partitions the array to left and right based on the pivotal.
 * by using recursion we can sort till the lowest element.
 * If we sort n elements it takes nsquare iteration but if we start splittong sorting says we split 100 as 50 and 50 and then sort then it will
 * be 50square + 50square + 100(to merge the two sorted subarrays) which is much lesser than 100square. This is the basic principle we are following
 * in merge and quick sorts.
 */
public class QuickSort {
    int[] arr = new int[]{2,5,3,1,3,4,5,7,888,54,33,2,11,987,664};

    public int partitionIt(int lower, int high, int pivot){

       int lowptr = lower;
       int highptr = high-1;//exclude pivot
        while(true) {
            while (arr[lowptr] < pivot) {
                lowptr++;
            }

            while (arr[highptr] > pivot && highptr > lower) {
                highptr--;
            }

            if (lowptr >= highptr) {
                break;
            }else{
                swap(lowptr,highptr);
            }

        }
        swap(lowptr,pivot);
        return lowptr;
    }

    public void swap(int dex1, int dex2) // swap two elements
    {
        int temp = arr[dex1]; // A into temp
        arr[dex1] = arr[dex2]; // B into A
        arr[dex2] = temp; // temp into B
    }

    public void quicksort(int lower,int high){

        if(lower>=high){
            return;
        }
        int pivot = partitionIt(lower, high, arr[high]);
        //at the end of partition pivot is in correct position hence omit it

        quicksort(lower,pivot-1);
        quicksort(pivot+1,high);


    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        q.quick1(0, q.arr.length-1, q.arr);
        for(int i: q.arr){
            System.out.println("FINAL "+ i);
        }
    }

    public void quick1(int left, int right, int[] arr){

        if(right <= left){
            return;
        }

        System.out.println("INVOKE POART " + arr[right]);
        int part = partition(left, right,  arr);
        System.out.println("AFTER POART " + part);
        for(int i: arr){
            System.out.println(i);
        }
        quick1(left,part-1, arr);
        quick1(part, right, arr);

    }

    public int partition(int left, int right,  int[] arr){

        int leftPtr=left;
        int rightPtr= right-1;
        int pos=0;

        while(rightPtr > leftPtr){
            //arr[right] is pivot
            if(arr[rightPtr] >= arr[right]){
               rightPtr--;

            }else{
                if(arr[leftPtr] > arr[right]){
                    int temp = arr[leftPtr];
                    arr[leftPtr] = arr[rightPtr];
                    arr[rightPtr] = temp;
                    rightPtr--;
                    leftPtr++;
                }else{
                    leftPtr++;

                }
            }


        }

        //sometimes left part could be greater or sometimes leftPart+1 will be greater
        if(arr[leftPtr] > arr[right]){
            pos=leftPtr;
        }else{
            pos=leftPtr+1;
        }

        int temp = arr[pos];
        arr[pos] = arr[right];
        arr[right] = temp;

        return pos;
    }
}
