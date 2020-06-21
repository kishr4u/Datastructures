package kotlintutorial

interface BasicInfoInterface{
    var providerInfoObj: String

    fun printInfo(person: Person){
        println("print overiden var $providerInfoObj")
    }
    //Interfaces can provide basic default implementation
    fun printInfoDefault(person: Person){
        println("print overiden var $providerInfoObj")
    }
}

interface SesssionInfo{
    fun getSessionId(): String
}
//class implementing multiple interfaces. you can also have abstract class. we declare class as open explicitly to allow inheritance
open class BasicInfo : BasicInfoInterface, SesssionInfo {
    override fun getSessionId(): String {
        return "original session"
    }

    override var providerInfoObj: String = ""
        get() = "BasicProvider"
    //notice here you have to specify the overide parameter unlike java
    override fun printInfo(person: Person) {
        println("basicinfo")

    }

}

fun main(args: Array<String>) {


    val basicInfoInterface: BasicInfoInterface = BasicInfo();
    basicInfoInterface.printInfo(Person());

    //here default implementation in interface invoked but the providerInfoOb variable will be overriden
    basicInfoInterface.printInfoDefault(Person())
    checkTypes(basicInfoInterface)

    //Anonymous inner class
    val provider= object: BasicInfo() {
        override fun getSessionId(): String {
            println("new anonymous session id")
            return "sessionoverridenanonymous"
        }
    }

    provider.printInfo(Person())
    provider.getSessionId();
}

fun checkTypes(basicInterface: BasicInfoInterface){
    if(basicInterface is SesssionInfo){
        println("It is a session info provider")
        //smart casting. since basic Interface is already checked for type SessionInfo we can call SessionInfo methods without explicit casting
        basicInterface.getSessionId()
    } else if(basicInterface !is SesssionInfo){
        println(
            "Not session info"
        )
    }
}