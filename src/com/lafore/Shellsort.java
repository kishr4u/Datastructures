package com.lafore;

public class Shellsort {
    private int[] arr = new int[]{2,4,3,1,77,44,9,43,23,56,22,12,11,19,18,17,16,15,27,26,10};

    public static void main(String[] args) {
        Shellsort s = new Shellsort();
        s.shellsort(0);
        for(int i:s.arr){
            System.out.println(i);
        }
    }

    public void shellsort(int increment){
        if(increment > arr.length){
            return;
        }

        shellsort(3*increment+1);
        if(increment > 0) {

            int last = increment;
            while (last + increment < arr.length) {
                last += increment;
            }

            System.out.println(" n is " + increment + "," + last);
            for (int position = last; position >= increment; ) {
                int current = position;
                System.out.println("current :" + current + "," + last);
                int temp = arr[current - increment];
                while (current <= last && temp > arr[current]) {
                    arr[current - increment] = arr[current];
                    current = current + increment;
                    System.out.println(" Current inside :" + current);
                }
                arr[current - increment] = temp;
                position = position - increment;
            }
        }

    }
}
