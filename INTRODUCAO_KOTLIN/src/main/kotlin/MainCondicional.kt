fun main() {

    val count : Int = 42;

    if (count == 42) {
        println("I have the answer.")
    } else {
        println("The answer eludes me.")
    }

    if (count == 42) {
        println("I have the answer.")
    } else if (count > 35) {
        println("The answer is close.")
    } else {
        println("The answer eludes me.")
    }

    val answerString: String = if (count == 42) {
        "I have the answer."
    } else if (count > 35) {
        "The answer is close."
    } else {
        "The answer eludes me."
    }

    println(answerString)

}