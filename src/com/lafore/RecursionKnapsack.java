package com.lafore;

public class RecursionKnapsack {

    int[] weights = new int[]{11, 8, 7, 6, 5};
    int target = 20;
    int len = weights.length;
    int lastPos =0;

    public static void main(String[] args) {
        RecursionKnapsack r = new RecursionKnapsack();

        r.doKnapsack(0, 0,0);


    }

    public void doKnapsack(int sum, int position,int k) {


        if(k == weights.length){
            System.exit(1);
        }
        if(position == weights.length){
            sum = sum - weights[lastPos];


            if(lastPos == weights.length-1){//if we have added till the end of the array and not met the target reset.
                sum=0;
                position = ++k;
                lastPos=0;
            }else{
                position=lastPos+1;
            }

        }



        if (sum+ weights[position] <= target) {
            sum = sum + weights[position];
            lastPos = position;
        }
        System.out.println("Sum :"+ sum + " Position :"+ position+ " lastpos :"+ lastPos);
        if (sum == target) {
            System.out.println("Found ");
            System.exit(0);
        }

        doKnapsack(sum, position+1,k);


    }
}
