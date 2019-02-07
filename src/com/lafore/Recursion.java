package com.lafore;

public class Recursion {

    public static void main(String[] args){
        triangularNumbers(1,0,10);
        factorial(5);
    }

    public static void triangularNumbers(int position, int prev, int limit){
        if(position== limit){
            return;
        }
        int num = prev + position;
        System.out.println(num);
        triangularNumbers(++position,num,limit);
    }

    public static int factorial(int n){

        if(n == 1){
            return 1;
        }


        int fact = n*factorial(n-1);
        System.out.println(fact);
        return fact;

    }
}
