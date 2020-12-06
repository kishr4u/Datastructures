package com.lafore;

public class SelectionSort {


    int[] arr = new int[]{2,77,4,23,5,66,32,7,99,454,33,43,897,1,3};

    public void selectionSort(){
        for(int out = arr.length-1; out>=0;out-- ) {
            int highest=0;
            for (int i = 0; i <= out; i++) {
                if (arr[i] > arr[highest]) {
                    highest = i;
                }
            }
            int temp = arr[out];
            arr[out] = arr[highest];
            arr[highest] = temp;

        }
        for(int s: arr)
        System.out.println(s);
    }

    public void insertionSort(){

        for(int out=1 ; out < arr.length;++out){
            int s = out;
            int temp = arr[out];

            while(s > 0 && arr[s-1] > temp  ){
                arr[s] = arr[s-1];
                --s;
            }
            arr[s] = temp;
        }

    }

    public static void main(String[] args){
       SelectionSort s =  new SelectionSort();
       s.insertionSort();
        for(int i:s.arr){
            System.out.println(i);
        }

    }

}
