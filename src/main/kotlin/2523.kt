import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextLine()
    var length = 1

    for (i in 1 until 2 * count.toInt()) {
        for (j in 1..length) {
            print('*')
        }
        if(i < count.toInt()) {
            length++
        } else {
            length--
        }

        println()
    }
}