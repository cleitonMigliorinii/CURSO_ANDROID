fun main() {

    val count : Int = 42;

    /**
     * Em Kotlin, a expressão when é usada para substituir várias instruções if-else if e
     * realizar uma correspondência de padrões mais concisa. Funciona como um switch-case mais poderoso e
     * flexível. Aqui está a estrutura básica do when em Kotlin
     */


    val answerString = when {
        count == 42 -> "I have the answer."
        count > 35 -> "The answer is close."
        else -> "The answer eludes me."
    }

    println(answerString)


    // ate 30KW -0,50
    // DE 31 A 300 - 0,72
    //ACIMA 300 - 1,03
    val kwExpenses : Double = 10.0

    when{
        kwExpenses <= 30 -> println("Valor gasto será  R$ ${kwExpenses * 0.5}")
        kwExpenses >= 31 && kwExpenses <= 300 -> println("Valor gasto será  R$ ${kwExpenses * 0.72}")
        else -> println("Valor gasto será  R$ ${kwExpenses * 1.03}")
    }


}