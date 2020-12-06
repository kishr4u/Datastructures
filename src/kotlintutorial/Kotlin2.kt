package kotlintutorial



fun main(args: Array<String>) {
    //you can have array of multiple types
    val things = arrayOf("judi", "mudi");
    //var nullobj1:String = null;you cannot define a String as null here as Strings are non nullable
    val an= "stst";
    val listThings = listOf("Ramy","jumy");
    val mapThings = mapOf("key1" to "val1","key2" to "val2")
    for (thing in things){
        println(thing)
    }


    //listThings.add("sss"); will have compilation error since by default list is immutable

    //lambda similar to java. u can use forEachIndexed if u want index also
    things.forEach { s-> print(s) }

    mapThings.forEach { key, val1 -> println(key + "val is $val1") }

    //by default collections are immutable so u cant add you dont see any mutable method .lets create a mutable collection for list
    val mutableList = mutableListOf("mut1","mut2")
    mutableList.add("soda")
    varArgFunction(10, "hh", "hhhh")
    varArgFunction(10, *things);//u can pass array to vararg with spread *.

    //invoking methiod with default parameters
    greetPerson()
}
//default parameters
fun greetPerson(greeting: String = "Hello ", name: String = "Kotlin"){

}

fun  varArgFunction(i: Int, vararg str: String){
    println( "name $str[0] another $str[1] " + str[0].toString())
    str.forEach { n-> println(n) }

}