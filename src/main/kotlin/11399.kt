import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    Solution11399().solve()
}

class Solution11399 {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    private val cntPerson = Integer.parseInt(br.readLine())
    private var inputTimeTokens = StringTokenizer(br.readLine())

    fun solve() {
        val sortedArrayList = arrayListOf<Int>()
        var amountTime = 0
        var allAmountTime = 0
        val leadTimes = arrayListOf<Int>()

        repeat(cntPerson) {
            val inputTime = Integer.parseInt(inputTimeTokens.nextToken())

            if(sortedArrayList.isNotEmpty()) {
                compareNumber(inputTime, sortedArrayList, 0)
            } else {
                sortedArrayList.add(inputTime)
            }
        }

        sortedArrayList.forEach {
            amountTime += it
            leadTimes.add(amountTime)
        }

        leadTimes.forEach { allAmountTime += it }

        bw.write("$allAmountTime")
        bw.flush()
        bw.close()

        br.close()
    }

    private fun compareNumber(targetNumber: Int, sortedList :ArrayList<Int>, idx: Int) {
        if(idx >= sortedList.size || targetNumber < sortedList[idx]) {
            sortedList.add(idx, targetNumber)
            return
        } else {
            compareNumber(targetNumber, sortedList, idx + 1)
        }
    }

}