package com.lafore;

public class OrderedArray {

    private int[] a = new int[100];
    int countElemens = 0;

    public static void main(String[] args){
        OrderedArray arr = new OrderedArray();
        arr.a = new int[]{3, 5, 7, 9, 13};
        arr.countElemens = 5;// represents the number of elements in array
        arr.insertWithBinarySearch(4);
        System.out.println("arr" + arr.a.toString());
    }

    public void insert(int s){
        if(countElemens < a.length) {
            int i = 0;
            int k = 0;
            for (; i < countElemens; i++) {
                if (a[i] > s) {
                    break;
                }
            }
            for (k = countElemens; k > i; k--) {
                a[k] = a[k - 1];
            }
            a[k] = s;
            countElemens++;
        }
    }

    public void insertWithBinarySearch(int s){
        boolean found = false;
        int lower = 0;int upper= countElemens;int k =0;

        while(true){
            int range = (lower + upper)/2;
            if(s >= a[range] && s <a[range + 1]){
                for (k = countElemens; k > range+1; k--) {
                    a[k] = a[k - 1];
                }
                a[range+1] = s;
                break;
            }
            else if(s > a[range] ){
                lower =range + 1;
            }else{
                upper = range -1;
            }
        }


    }

    public void delete(int s){
        if(countElemens != 0) {
            int i = 0;
            int k = 0;
            for (; i < countElemens; i++) {
                if (a[i] == (s)) {
                    break;
                }
            }
            for (k=i; k < countElemens; k++) {
                a[k] = a[k + 1];
            }
            a[k] = 0;
            countElemens--;
        }

    }

    public boolean binarySearch(int s){
        boolean found = false;
        int lower = 0;int upper= countElemens;

        while(true){
            int range = (lower + upper)/2;
            if(a[range] ==s){
                found = true;
                break;
            }else if(lower < upper){
                found = false;
                break;
            }
            else if(s > a[range] ){
                lower =range + 1;
            }else{
                upper = range -1;
            }
        }

        return found;
    }
}
