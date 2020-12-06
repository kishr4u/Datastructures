package com.lafore;

/**
 * Anagram of words using recusion. the no. of anagrams possible for a word is n factorial, so this is also a general solution towards
 * any factorial based problems
 */
public class RecursionAnagram {

    private static String anag = "KISHO";
    private static int i = 0;

    public static  void doAnagram(int size){
//        if(size == 1){
//            return;
//        }
        for(int k=0; k < size; k++){
            doAnagram(size -1);
            if(size==1) {//to eliminate duplicates
                System.out.println("Execution :" + size + "count :" + ++i);
                System.out.println(anag);
            }

        }

    }

    public static void main(String[] args){
        doAnagram(5);
    }
}
