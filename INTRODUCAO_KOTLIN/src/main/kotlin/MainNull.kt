fun main() {


    // Em Kotlin, você pode indicar que uma variável pode conter um valor nulo
    // ao adicionar um ? ao tipo da variável.
    // Isso significa que a variável pode conter um valor válido do tipo especificado ou ser nula.
    var countChange: Int? = null;
    val texto: String? = null

    //Para acessar propriedades ou chamar métodos em variáveis que podem ser nulas,
    // você pode usar o operador de chamada segura (?.).
    // Se a variável for nula, a expressão inteira será avaliada como nula.
    val comprimento: Int? = texto?.length


    
}