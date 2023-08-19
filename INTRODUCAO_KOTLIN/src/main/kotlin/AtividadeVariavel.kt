import java.time.LocalDate

fun main() {

    //Atividade

    var age: Int = 42
    val name : String = "Cleiton"
    val salary : Double = 2000.0
    val isRetired : Boolean = true

    println("Idade é $age")
    println("Nome é $age")
    println("Salario é $age")
    println("É Aposentado $age")

    //Calculo de idade
    val currentYear :Int = LocalDate.now().year
    val birthYear : Int = 1993

    age = currentYear - birthYear

    println("Sua idade é $age")

    //Calculo triangulo retangulo
    var base: Double = 10.0
    var altura: Double = 20.0

    val area: Double = base*altura/2

    println("Area $area")

}