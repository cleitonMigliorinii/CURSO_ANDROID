import java.time.LocalDate

fun main() {

    val idade : Int = getIdade()
    println("Idade é ${idade}")

    val idadeParametro : Int = getIdade(1993, 2023)
    println("Idade é via parametro ${idade}")
}

fun getIdade(): Int{

    //Calculo de idade
    val currentYear :Int = LocalDate.now().year
    val birthYear : Int = 1993

    return currentYear - birthYear
}

fun getIdade(anoNascimento: Int, anoAtual: Int): Int{

    return anoNascimento - anoAtual
}