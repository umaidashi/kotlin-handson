package fizzbuzz_when

fun fizzBuzzWhen(i: Int): String {
    val result: String
    when {
        i % 15 == 0 -> {
            result = "FizzBuzz"
        }

        i % 3 == 0 -> {
            result = "Buzz"
        }

        i % 5 == 0 -> {
            result = "Fizz"
        }

        else -> {
            result = "$i"
        }
    }
    return result
}

fun main() {
    for (i in 1 .. 30) {
        println(fizzBuzzWhen(i))
    }
}
