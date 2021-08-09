package thisIsCodingTest.review

import java.util.Queue
import java.util.LinkedList

private fun solution(n:Int, v:Int, arr:Array<Pair<Int, Int>>):IntArray{
    val answer = mutableListOf<Int>()
    val indegree = IntArray(n + 1)
    val graph = MutableList<MutableList<Int>>(n + 1){ mutableListOf() }.apply{
        arr.forEach {
            this[it.first].add(it.second)
            indegree[it.second]++
        }
    }
    val q:Queue<Int> = LinkedList<Int>().apply {
        indegree.forEachIndexed{ i, item -> if(item == 0 && i != 0){ offer(i) } }
    }

    while(q.isNotEmpty()){
        graph[q.poll().apply(answer::add)].filter { --indegree[it] == 0 }.forEach(q::offer)
    }

    return answer.toIntArray()
}

private fun main(){
    val arr = arrayOf(1 to 2, 1 to 5, 2 to 3, 2 to 6, 3 to 4, 4 to 7, 5 to 6, 6 to 4)
    println("1\t2\t5\t3\t6\t4\t7")
    solution(7, 8, arr).forEach { print("${it}\t") }
}