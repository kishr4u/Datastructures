package algorithms

import kotlintutorial.BasicInfo
import kotlintutorial.Person

class ChildClassProvider: BasicInfo() {
    //override var and methods
    override var providerInfoObj: String
        get() = "ChildClassProvider"
        set(value) {}

    override fun printInfo(person: Person) {
        super.printInfo(person)
    }
}