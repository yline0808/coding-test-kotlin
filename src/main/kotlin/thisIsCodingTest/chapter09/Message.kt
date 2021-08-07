package thisIsCodingTest.chapter09

import java.util.PriorityQueue

private fun solution(n:Int, m:Int, start:Int, arr:Array<IntArray>):IntArray{
    data class Node(val index:Int, val distance:Int):Comparable<Node>{
        override fun compareTo(other:Node):Int{
            return this.distance - other.distance
        }
    }

    val answer = IntArray(2)
    val data = IntArray(n + 1){ 1e9.toInt() }.apply { this[start] = 0 }
    val graph = MutableList<MutableList<Node>>(n + 1){ mutableListOf() }.apply {
        arr.forEach { this[it[0]].add(Node(it[1], it[2])) }
    }
    val pq = PriorityQueue<Node>().apply { offer(Node(start, 0)) }

    while(pq.isNotEmpty()){
        val node = pq.poll()
        if(data[node.index] < node.distance) continue
        for(nextNode in graph[node.index]){
            val cost = data[node.index] + nextNode.distance
            if(cost < data[nextNode.index]){
                data[nextNode.index] = cost
                pq.offer(Node(nextNode.index, cost))
            }
        }
    }
    answer[0] = data.count { it != 0 && it < 1e9.toInt() }
    answer[1] = data.filter { it < 1e9.toInt() }.maxOrNull()!!

    return answer
}

private fun main(){
    val arr1 = arrayOf(intArrayOf(1,2,4), intArrayOf(1,3,2))
    val arr2 = arrayOf(
        intArrayOf( 1, 2, 2 ), intArrayOf( 1, 3, 5 ), intArrayOf( 1, 4, 1 ),
        intArrayOf( 2, 3, 3 ), intArrayOf( 2, 4, 2 ), intArrayOf( 3, 2, 3 ),
        intArrayOf( 3, 6, 5 ), intArrayOf( 4, 3, 3 ), intArrayOf( 4, 5, 1 ),
        intArrayOf( 5, 3, 1 ), intArrayOf( 5, 6, 2 ))

    println("2\t4")
    solution(3,2,1,arr1).forEach { print("${it}\t") }
    println("\n5\t4")
    solution(6,11,1, arr2).forEach { print("${it}\t") }
}