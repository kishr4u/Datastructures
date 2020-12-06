package com.lafore;

import java.util.ArrayList;
import java.util.Arrays;

public class List {

    private String[] a = new String[100];
    public int[][] i = {{1,1},{2,2}};//unused
    int position = 0;


    //O(1)
    public void insert(String s){
        if(position < a.length) {
            a[position] = s;
            position++;
        }else{
            String[] copy = new String[position*2];//create an array of double the capacity
            for (int i = 0; i < a.length; i++) {
                copy[i] = a[i];

            }
            a= copy;

        }
    }

    //O(n)
    public void delete(String s){
        if(position != 0) {
            int i = 0;
            int k = 0;
            for (; i < position; i++) {
                if (a[i].equals(s)) {
                    break;
                }
            }
            for (k=i; k < position; k++) {
                a[k] = a[k + 1];
            }
            a[k] = null;
            position--;

        }

    }

    public String get(int index){
        return a[index];
    }

    //O(n)
    public boolean search(String s){
        int i = 0;int k=0;
        boolean found = false;
        for(; i< a.length; i++){
            if(a[i].equals(s)){
                found = true;
                break;

            }
        }
        return found;

    }
}
