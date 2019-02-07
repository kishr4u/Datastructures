package com.lafore;

public class Array {

    private String[] a = new String[100];
    int position = 0;

    public void insert(String s){
        if(position < a.length) {
            a[position] = s;
            position++;
        }
    }

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
