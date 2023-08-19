fun main() {

    // ate 30KW -0,50
    // DE 31 A 300 - 0,72
    //ACIMA 300 - 1,03
    val kwExpenses : Double = 10.0

    if (kwExpenses <= 30) {
        println("Valor gasto será  R$ ${kwExpenses * 0.5}")
    } else if (kwExpenses >= 31 && kwExpenses <= 300) {
        println("Valor gasto será  R$ ${kwExpenses * 0.72}")
    } else {
        println("Valor gasto será  R$ ${kwExpenses * 1.03}")
    }

}