package fizzbuzz_if

fun fizzBuzzLong(i: Int): String {
    val result: String
    if (i % 15 == 0) {
        result = "FizzBuzz"
    } else if (i % 3 == 0) {
        result = "Fizz"
    } else if (i % 5 == 0) {
        result = "Buzz"
    } else {
        result = "$i"
    }
    return result
}

fun fizzBuzzEarlyReturn(i: Int) :String {
    if (i % 15 == 0) {
        return "FizzBuzz"
    } else if (i % 3 == 0) {
        return "Fizz"
    } else if (i % 5 == 0) {
        return "Buzz"
    } else {
        return "$i"
    }
}

fun fizzBuzzFormula(i: Int): String {
    val result = if (i % 15 == 0) {
        "FizzBuzz"
    } else if (i % 3 == 0) {
        "Fizz"
    } else if (i % 5 == 0) {
        "Buzz"
    } else {
        "$i"
    }
    return result
}

fun fizzBuzzReturnFormula(i: Int): String {
    return if (i % 15 == 0) {
        "FizzBuzz"
    } else if (i % 3 == 0) {
        "Fizz"
    } else if (i % 5 == 0) {
        "Buzz"
    } else {
        "$i"
    }
}

fun main() {
    for (i in 1..100) {
        println(fizzBuzzLong(i))
    }
    for (i in 1..100) {
        println(fizzBuzzEarlyReturn(i))
    }
    for (i in 1..100) {
        println(fizzBuzzFormula(i))
    }
    for (i in 1..100) {
        println(fizzBuzzReturnFormula(i))
    }
}