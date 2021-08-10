package thisIsCodingTest.review

import java.util.Queue
import java.util.LinkedList

private fun solution(n:Int, arr:Array<IntArray>):IntArray{
    val times = IntArray(n + 1)
    val indegree = IntArray(n + 1)
    val graph = Array<MutableList<Int>>(n + 1){mutableListOf()}.apply{
        arr.forEachIndexed { idx, row ->
            times[idx + 1] = row[0]
            for(j in 1 until row.size){
                indegree[idx + 1]++
                this[row[j]].add(idx + 1)
            }
        }
    }

    val q:Queue<Int> = LinkedList<Int>().apply{
        indegree.forEachIndexed{ idx, item -> if(item == 0 && idx != 0) offer(idx) }
    }
    val answer = IntArray(n + 1){ times[it] }

    while(q.isNotEmpty()){
        val now = q.poll()
        for(next in graph[now]){
            answer[next] = answer[next].coerceAtLeast(answer[now] + times[next])
            if(--indegree[next] == 0) q.offer(next)
        }
    }

    return answer.sliceArray(1..n)
}

private fun main(){
    val arr = arrayOf(
        intArrayOf(10), intArrayOf(10,1), intArrayOf(4,1),
        intArrayOf(4,3,1), intArrayOf(3,3))
    println("10\t20\t14\t18\t17")
    solution(5, arr).forEach { print("${it}\t") }
}