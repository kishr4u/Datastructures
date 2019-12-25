package algorithms

//kotlin can automatically detect type and types are non nullable by default unless we have ? as below
val topVar= "IamTop";
//In kotlin variables are non nullable types by default. to assign null add ? to the type;
val nullablestr:String? = null

//all these functions are not inside a class and called top level functions
fun main(args: Array<String>) {
    //var can be changed
    var name:String = "Kishore";
    //val is constant and final
    val finName = "Judy";
    name = "Rahul";

    //no null pointer exception thrown it just ignores
    nullablestr.toString()

    println(name)

    //If else is similar to java but we can assign the result to a var
    var abc = if(name.equals("Rahul"))  "goli" else "juli"
    //when is similar to switch case and u can assign to variable similar to if above
    when(topVar){
        null -> println("its null")
        "IamTop" -> println("you are on top")
        else -> println("default case")
    }
    //passinf parameters similar to java
    getGreeting("jubi");
}
//if no return type specified then it means void
fun getGreeting(name:String):String{
    //return "hello getGreeting"+ name;
    //supports string template which we can use in a constant $
    return  "hello $name"
}

//single expression function. can be used for getters
fun getName():String = topVar

//void functions are of implicit type Unit
fun getVoidFun(name1:String,name2:String) = print("$name1 hello $name2")