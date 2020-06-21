package kotlintutorial


//Higher order functions. we can pass functions as parameters to a method. Kotlin has functions as types
fun printFilteredString(list:List<String>, predicate1 : (String) -> Boolean){
    list.forEach {
        if(predicate1(it)){
            println("name $it")
        }
    }
    val i = 0
//    list.forEachIndexed<String>() {
//       //print(it);
//    }
}

//we can also assign a function to variable and pass it
val predicateVariable: (String) -> Boolean = {
    it.startsWith("k")
}

fun main(args: Array<String>) {
    val list= listOf<String>("kish","merli","Arshu","Aru")
    printFilteredString(list, { it.startsWith("a") })//pass a function as paramater
    //or you can also do this. If you see the implemebtation of for each its just a higher order function
    printFilteredString(list) {
        it.startsWith("a")
    }

    //pass the variable as a function
    printFilteredString(list, predicateVariable)

    //Invoke the function below to get the function body
    printFilteredString(list, getPrintPredicate())

}

//we can also return other functions as parameters
fun getPrintPredicate(): (String) -> Boolean {
    return {it.startsWith("pref")}
}