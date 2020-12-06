package com.lafore;

public class RecursionKnapsack {

    int[] weights = new int[]{19, 3, 6, 3, 6, 11};
    int target = 20;
    int len = weights.length;
    int lastPos =0;
    int choosenIndex=0;
    int itrCount=0;

    public static void main(String[] args) {
        RecursionKnapsack r = new RecursionKnapsack();
//        r.lastPos++;
//        r.doKnapsack1(r.weights[0], r.choosenIndex+1);
          r.doKnapsack(0,0,0);



    }

    public void doKnapsack(int sum, int position,int k) {


        ++itrCount;
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
            System.out.println("Found "+ itrCount);
            System.exit(0);
        }

        doKnapsack(sum, position+1,k);


    }

    public void doKnapsack1( int sum, int position){
        ++itrCount;

      if(position==weights.length){
          if(lastPos<weights.length-1){
              ++lastPos;
              position=lastPos;
              sum=weights[choosenIndex];

          }else{
              if(choosenIndex < weights.length-1){

                   ++choosenIndex;
                  sum=weights[choosenIndex];
                  if(choosenIndex < weights.length -1) {
                      lastPos = choosenIndex + 1;
                      position = choosenIndex + 1;
                  }else{
                      lastPos = choosenIndex ;
                      position = choosenIndex ;
                  }

              }else{
                  System.out.println("not found" + itrCount);
                  System.exit(0);
              }

          }

      }


        System.out.println(" index"+ sum + "," + position + ","+ lastPos);
      if(sum+ weights[position] <= target){
          sum+=weights[position];
      }
      if(sum== target){
          System.out.println("Found "+ itrCount);
          System.exit(0);
      }

        doKnapsack1(sum,position+1);

    }
}
