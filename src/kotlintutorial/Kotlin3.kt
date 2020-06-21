package kotlintutorial

fun main(args: Array<String>) {
    var p = Person("kish", "jagannath")
    p.firstName = "subu";
    println(p.getFullName())
    p.mobile="9686"
    println(p.mobile)

}