package thisIsCodingTest.chapter05

import java.util.Queue
import java.util.LinkedList

private fun bfs(graph:Array<IntArray>, start:Int, visited:BooleanArray){
    val q:Queue<Int> = LinkedList<Int>()
    visited[start] = true
    q.offer(start)

    while(q.isNotEmpty()){
        val n = q.poll()
        print("${n}\t")
        for(i in graph[n]){
            if(!visited[i]) {
                q.offer(i)
                visited[i] = true
            }
        }
    }
}

private fun main(){
    val graph = arrayOf(
        intArrayOf(),
        intArrayOf(2,3,8),
        intArrayOf(1,7),
        intArrayOf(1,4,5),
        intArrayOf(3,5),
        intArrayOf(3,4),
        intArrayOf(7),
        intArrayOf(2,6,8),
        intArrayOf(1,7)
    )

    intArrayOf(1,2,3,9,7,4,5,6).forEach { print("${it}\t") }
    println()
    bfs(graph, 1, BooleanArray(9))
}