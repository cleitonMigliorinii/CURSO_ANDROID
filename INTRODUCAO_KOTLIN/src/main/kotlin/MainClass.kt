abstract  class  Dwelling(private var resident: Int){

    abstract val buildingMaterial : String
    abstract val capacity: Int

    fun hasRoom() : Boolean {
    return  resident < capacity
    }
}

class SquareCabin(resident: Int) : Dwelling(resident){

    override val buildingMaterial = "Wood"
    override val capacity = 6

}

open class RoundHut(resident: Int) : Dwelling(resident){

    override val buildingMaterial = "Straw"
    override val capacity = 4

}

class RoundTower(resident: Int, floors : Int) : RoundHut(resident){

    override val buildingMaterial = "Straw"
    override val capacity = 4 * floors

}

fun main() {

    var squareCabin = SquareCabin(6)

    with(squareCabin){
        println(" Capacity : ${capacity}")
        println(" Meterial : ${buildingMaterial}")
        println(" has Room : ${hasRoom()}")
    }

    var roundHut = RoundHut(6)

    with(roundHut){
        println(" Capacity : ${capacity}")
        println(" Meterial : ${buildingMaterial}")
        println(" has Room : ${hasRoom()}")
    }

    var roundTower = RoundTower(6,2)

    with(roundTower){
        println(" Capacity : ${capacity}")
        println(" Meterial : ${buildingMaterial}")
        println(" has Room : ${hasRoom()}")
    }
}