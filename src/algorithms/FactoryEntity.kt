package algorithms

import javax.swing.text.html.parser.Entity

interface Provider{
    fun getId():String
}

class FactoryEntity private constructor(val id:String){
    // Kotlin doesnt have static methods and variables. we declare those things in companion and calling method can just do ClassName.
    //difference is companions can also implement interfaces
    companion object : Provider{
        override fun getId(): String {
            return "id112"
        }

        fun create() = FactoryEntity(getId())

    }
}
//In kotlin object provides a single instance. you can create multiple instance of class whereas only instance of object similar to singleton
object DemoObject{
    fun getSomeVar():String{
        return "123"
    }
}

enum class TypesDemo{
    EASY,HARD,MEDIUM
}
//Learn more about sealed and data class online
sealed class SealedEntity{
    //data class equals and hashcode generated.but we can overide as well
    data class Easy(val id:String,val name:String):SealedEntity(){
        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }
    data class Medium(val id:String,val name:String):SealedEntity()
    data class Hard(val id:String,val name:String):SealedEntity()
}

//extension functions. you can extend classes with additional methids
fun SealedEntity.Medium.newExtendedMethod(){
    println("my new extended method")
}
//extension properties
val SealedEntity.Medium.extendedProp:String
    get() = "abced"

class DemoFactory{
    companion object {
        fun createTypedDemo(typesDemo: TypesDemo):SealedEntity{
            val demoType = when(typesDemo){

                TypesDemo.EASY -> SealedEntity.Easy("ideasy","nameeasy")
                TypesDemo.HARD -> SealedEntity.Hard("idmedium","namemedium")
                TypesDemo.MEDIUM -> SealedEntity.Medium("idhard","namehard")
            }
            return demoType
        }
    }

}

fun main(args: Array<String>) {
    //we are directly accessing method and variables inside a class using companion an alternative to java static. Only difference is companion can also
    //implement interface we
    val entity = FactoryEntity.Companion.create();

    //you can create instance of DemoObject since its an object
    DemoObject.getSomeVar();

    val demoType = DemoFactory.createTypedDemo(TypesDemo.EASY)
    var easyData = SealedEntity.Easy("1","hubi")
    //copy data classes
    var newEasyDataCopy = SealedEntity.Easy("1","hubi").copy(id = "new id");

    println(newEasyDataCopy.name)

    //to compare just use == it will compare the values of both objects and not reference like java
    val isEqual = if(easyData == newEasyDataCopy) "equal" else "not equal"
    //this compares reference and not the values
    val isEqualReference = if(easyData === newEasyDataCopy) "equal" else "not equal"
    println(isEqual)

    //can invoke the extended methoid of medium class
    var mediumData = SealedEntity.Medium("1","hubi").newExtendedMethod()

}