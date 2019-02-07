package com.lafore;

public class Partition {
    private static long[] arr = new long[100];

    public static void main(String[] args){
        arr = new long[]{5,2,44,22,9,66,22,1,3,5,8,44,27,77,49,7};

    }

    static void partition(int left, int right, int pivot){
        while(true) {
            int leftptr = left;
            int rightptr = right;
            while (leftptr < right && arr[leftptr] <= pivot) {
                leftptr++;
            }
            while (rightptr < left && arr[rightptr] >= pivot) {
                rightptr--;
            }

            if(left>= right)
                break;

            swap(left,right);



        }



    }

    public static void swap(int dex1, int dex2) // swap two elements
    {
        long temp;
        temp = arr[dex1]; // A into temp
        arr[dex1] = arr[dex2]; // B into A
        arr[dex2] = temp; // temp into B

    }

}
