fun main() {

    Solution25176().solve()
}

/**
 * numList을 (1..num) + (1..num) 이런식으로 놓고 풀으려니까 답이 안나왔다 ...
 * 최소값의 개수를 찾으면 되는 문제 이므로
 * 최소값이 되는 경우를 아는것이 관건 이었음..
 * 예를들어 num이 3 이면
 *
 * [1,1,2,2,3,3] 이런식으로 같은 값이 서로 붙어있어야 최소값이 되니까
 * [1,2,3] 의 순열을 찾으면 되는 문제였음 ..
 * */
class Solution25176 {
    private val num = readLine()!!.toInt()
    private val numList = (1..num).toList()
    private var sum = 0

    fun solve() {
        permutation(0, mutableListOf(), BooleanArray(num) { false })

        println(sum)
    }

    private fun permutation(depth: Int, measurerList: MutableList<Int>, isVisited: BooleanArray) {
        if(depth == num) {
            sum++

            return
        }

        for(i in numList.indices) {
            if(!isVisited[i]) {
                isVisited[i] = true
                measurerList.add(numList[i])
                permutation(depth + 1, measurerList, isVisited)
                measurerList.removeAt(measurerList.lastIndex)
                isVisited[i] = false
            }
        }
    }
}