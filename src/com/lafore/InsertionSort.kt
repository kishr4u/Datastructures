package com.lafore

val ints=  arrayOf(3,1,77,88,4,99,900,7,200,400,800,2,1000,1234);
fun main() {
insertionSort();

}

fun insertionSort() {


    for (i in ints.indices -1){
        println(i)
        var index = 0;
        var pos = i+1
        var temp = ints[i+1];
        while( pos > 0 && ints[pos-1] > temp ) {
            ints[pos] = ints[pos-1];
            --pos
        }
        ints[i] = temp;


    }

}

