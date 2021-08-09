package thisIsCodingTest.chapter10

import java.util.Queue
import java.util.LinkedList

// 위상정렬

private fun solution(n:Int, arr:IntArray):IntArray{
    val answer = IntArray(n + 1)
    val indegree = IntArray(n + 1)
    val times = intArrayOf(0, 10, 10, 4, 4, 3)
    val graph = MutableList<MutableList<Int>>(n + 1){ mutableListOf() }

    for(data in arr){

    }

    val q:Queue<Int> = LinkedList<Int>()

    return answer
}

private fun main(){
//    val arr = arrayOf(intArrayOf(1,10), intArrayOf(2,10,1), intArrayOf(3,4,1), intArrayOf(4,4,3,1), intArrayOf(5,3,3))
    val arr = intArrayOf(
        10, -1,
        10, 1, -1,
        4, 1, -1,
        4, 3, 1, -1,
        3, 3, -1)
    println("10\t20\t14\t18\t17")
    solution(5, arr).forEach { print("${it}\t") }
}
