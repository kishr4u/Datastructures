package com.lafore;

/** A combination is usually n!/(n-k)!(k)! where is the total option and k is the chosen group siz. For e.g picking 3 players from a group of 5.
 * It can be represented as 5c3 = 4c3 + 4c2and so on
 */
public class RecursionCombination {
    static int i = 0;
    public StringBuffer buffer = new StringBuffer();

    public static void doRecursion(int n, int k){

        System.out.println("loop" + n + ","+ k+ ","+ ++i);
        if( n<= 0 || k <=0 ){
            return;
        }


        if(n==1 && n >=k){
            System.out.println("FOUND COMBINATION" + n + ","+ k+","+ ++i);

        }
        doRecursion(n-1,k);

        doRecursion(n,k-1);
    }

    public static void main(String[] args){
        doRecursion(5,5);
    }

}
