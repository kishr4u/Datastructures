package com.lafore;

public class Sort {
    private long[]a = new long[100];
    private int nElems,min;
    int count = 0;

    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }
    //--------------------------------------------------------------
    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(a[j] + ""); // display it
        System.out.println("");
    }


    public void bubbleSort(){

        for(int i = 0; i <nElems-1;i++){
            for(int k =nElems -1;k>i;k--){
                if(a[k] < a[k-1]){
                    a[k] = a[k] + a[k-1];
                    a[k-1] = a[k] -a[k-1];
                    a[k] = a[k] - a[k-1];
                }
            }
        }
    }

    /**
     * no. of comparisons is n*(n-1)/2 and no. of swaps is n*(n-1)/2
     */
    public void bubbleSort2(){

        for(int i = 0; i <nElems-1;i++){
            for(int k =0;k<nElems-1 -i;k++){
                if(a[k] < a[k+1]){
                    a[k] = a[k] + a[k+1];
                    a[k+1] = a[k] -a[k+1];
                    a[k] = a[k] - a[k+1];
                }
            }
        }
    }

    /**
     * no. of comparisons is n*(n-1)/2 and no. of swaps is n
     */
    public void selectionSort(){
        for(int i = 0; i <nElems;i++){
            min = 0;
            for(int k =0;k<nElems -i;k++){
                if(a[k] < a[min]){
                    min = k;
                }
            }
            long temp = a[min];
            a[min] = a[nElems -1 -i];
            a[nElems -1 - i] = temp;
        }
    }

    /**
     * if the data is almost sorted insertion sort does much better as it checks for the condition in while loop and doesnt blindly swap always
     * like a bubble sort. If data is in inverse sort order performance same as bubble sort.
     */
    public void insertionSort(){
        for(int i=1 ; i < nElems  ; i++){
            int k=i;
            while(k >0 && a[k] < a[k-1]  ){
                long temp = a[k];
                a[k] = a[k-1];
                a[k-1] = temp;

                k--;
            }
        }
    }


    /**
     * Shell sort is very similar to insertion sort. if u see we have just introduced a h else code is almost same. in shell sort we choose a random
     * h say h = 3*h+1(1,4,13,40,121...)and then sort all the items in the h interval. so we sort all items in 13 interval and then 4 interval
     * before finally sorting in 1 interval(1 interval is similar to insertion sort above substitute h = 1). So by the time we reach 1 interval the array
     * is almost sorted so insertion sort will take approximate O(N) iteration and not O(N**2). shell sort operates in n(logN)square time.
     */
    public void shellSort(){
        int h = 1;

        while(h < nElems/3){//1,4,13,40,121,..
            h = 3*h + 1;
        }
        while (h > 0){



            for(int i = h; i < nElems;i++){
                int k = i;
                while(k > h-1 && a[k] < a[k-h]){
                    long temp = a[k];
                    a[k] = a[k-h];
                    a[k-h] = temp;

                    k = k-h;
                }

            }
            h=(h-1)/3;
        }
    }

    /**
     * Avoids swapping
     */
    public void insertionSort1(){
        for(int i=1 ; i < nElems  ; i++){
            int k=i;
            long temp = a[i];
            while(k >0 && a[k-1] > temp  ){

                a[k] = a[k-1];


                k--;
            }
            a[k] = temp;
        }
    }
    public static void main(String[] args){
        Sort s = new Sort();
        s.a = new long[]{3,5,1,9,2,3,7,11,10,19,100,79,34,55,44,2,0};
        s.nElems=s.a.length;
        s.shellSort();
        System.out.println(s.a);



    }
}
