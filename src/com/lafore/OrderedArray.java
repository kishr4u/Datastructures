package com.lafore;

public class OrderedArray {

    private int[] a = new int[100];
    int position = 0;

    public static void main(String[] args){
        OrderedArray arr = new OrderedArray();
        arr.a = new int[]{3, 5, 7, 9, 13};
        arr.position= 4;
        arr.insertWithBinarySearch(4);
        System.out.println("arr" + arr.a.toString());
    }

    public void insert(int s){
        if(position < a.length) {
            int i = 0;
            int k = 0;
            for (; i < position; i++) {
                if (a[i] > s) {
                    break;
                }
            }
            for (k = position; k > i; k--) {
                a[k] = a[k - 1];
            }
            a[k] = s;
            position++;
        }
    }

    public void insertWithBinarySearch(int s){
        boolean found = false;
        int lower = 0;int upper=position;int k =0;

        while(true){
            int range = (lower + upper)/2;
            if(s >= a[range] && s <a[range + 1]){
                for (k = position; k > range+1; k--) {
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
        if(position != 0) {
            int i = 0;
            int k = 0;
            for (; i < position; i++) {
                if (a[i] == (s)) {
                    break;
                }
            }
            for (k=i; k < position; k++) {
                a[k] = a[k + 1];
            }
            a[k] = 0;
            position--;
        }

    }

    public boolean binarySearch(int s){
        boolean found = false;
        int lower = 0;int upper=position;

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
