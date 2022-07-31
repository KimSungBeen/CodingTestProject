import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val count = sc.nextLine()
    var length = 1

    val sb = StringBuilder()

    for (i in 1 until 2 * count.toInt()) {
        for (j in 1..length) {
            sb.append('*')

            if(j == length) sb.append("\n")
        }

        if(i < count.toInt()) {
            length++
        } else {
            length--
        }
    }

    print(sb)
}