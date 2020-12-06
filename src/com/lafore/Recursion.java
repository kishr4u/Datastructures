package com.lafore;

import java.util.Scanner;

public class Recursion {

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null)
                && (!str.equals(""))
                && (str.chars().allMatch(ch -> Character.isLetter(ch))));
    }
    public static void main(String[] args){
        //triangularNumbers(1,0,10);
        int x = 5 | 7;

        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String first1 = sc.next();
        System.out.println(x);
        triangularNumbers1(10);
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

    public static int triangularNumbers1( int num){
        if(1 == num){
            return 1;
        }

        int ans = num + triangularNumbers1(--num);
        System.out.println(ans);
        return ans;
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
