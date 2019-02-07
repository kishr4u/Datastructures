package com.lafore;

public class RecursionPower {


    public static int doPower(int x, int y){
        System.out.println("x is"+ x + ", "+y);
        if(y==1){
            return x;
        }


        int ans = doPower(x*x,y/2);//as the recursion loop ends the final answer get stored.
        System.out.println("x is "+ x + ", "+y + "," + ans);
        if(y%2!= 0){//as it unwinds
            System.out.println(" odd x is"+ x + ", "+y);
            return ans*x;
        }
        return ans;
    }

    public static void main(String[] args){

        System.out.println(RecursionPower.doPower(2,15));
    }
}
