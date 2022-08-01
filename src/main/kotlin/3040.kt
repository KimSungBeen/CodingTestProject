import java.lang.StringBuilder

fun main() {
    val numbers = List(9) { readLine()!!.toInt() }
    val sb = StringBuilder()

    get100(numbers).forEach {
        sb.append(it)
        sb.append("\n")
    }

    print(sb)
}

fun get100(numbers: List<Int>): List<Int> {
    val numbersArrayList = ArrayList(numbers)
    var sum = 0

    for(i in 0..numbers.lastIndex) {
        for (j in i + 1..numbers.lastIndex) {
            val newList = numbersArrayList.toMutableList().apply {
                remove(numbers[i])
                remove(numbers[j])
            }
            newList.forEach { sum += it }

            if(sum == 100) {
                return newList.toList()
            } else {
                sum = 0
            }
        }
    }
    return emptyList()
}