package vimTest

import java.util.PriorityQueue

private fun solution(n:Int, start:Int, arr:Array<IntArray>):IntArray{
	data class Node(val index:Int, val distance:Int):Comparable<Node>{
		override fun compareTo(other:Node):Int{
			return this.distance - other.distance
		}
	}

	val answer = IntArray(n + 1){ 1e9.toInt() }.apply{ this[start] = 0 }
	val pq = PriorityQueue<Node>().apply{ offer(Node(start, 0)) }
	val graph = MutableList<MutableList<Node>>(n + 1) { mutableListOf() }.apply{
		arr.forEach{ this[it[0]].add(Node(it[1], it[2])) }
	}

	while(pq.isNotEmpty()){
		val node = pq.poll()
		if(answer[node.index] < node.distance) continue
		for( nextNode in graph[node.index]){
			val cost = answer[node.index] + nextNode.distance
			if(cost < answer[nextNode.index]){
				answer[nextNode.index] = cost
				pq.offer(Node(nextNode.index, cost))
			}
		}
	}
	return answer.sliceArray(1..n)
}

private fun main(){
	val arr = arrayOf(
        intArrayOf( 1, 2, 2 ), intArrayOf( 1, 3, 5 ), intArrayOf( 1, 4, 1 ),
        intArrayOf( 2, 3, 3 ), intArrayOf( 2, 4, 2 ), intArrayOf( 3, 2, 3 ),
        intArrayOf( 3, 6, 5 ), intArrayOf( 4, 3, 3 ), intArrayOf( 4, 5, 1 ),
        intArrayOf( 5, 3, 1 ), intArrayOf( 5, 6, 2 ))
    println("0\t2\t3\t1\t2\t4")
    solution(6,1,arr).forEach { print("${it}\t") }
}
