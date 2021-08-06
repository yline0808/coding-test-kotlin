package thisIsCodingTest.chapter09

import java.util.PriorityQueue

// 기본 (별로임)
private const val INF = 1e9.toInt()

private fun getSmallestNode(d:IntArray, visited:BooleanArray):Int{
    var minValue = INF
    var node = 0

    for(i in 1 until d.size){
        if(d[i] < minValue && !visited[i]){
            minValue = d[i]
            node = i
        }
    }

    return node
}

private fun dijkstra1(n:Int, l:Int, start:Int, arr:Array<IntArray>):IntArray{
    data class Node(val index:Int, val distance:Int):Comparable<Node>{
        override fun toString():String{
            return "[${this.index}] : ${this.distance}\t"
        }

        override fun compareTo(other: Node): Int {
            return this.distance - other.distance
        }
    }

    val answer = IntArray(n + 1){INF}.apply { this[start] = 0 }
    val graph = MutableList<MutableList<Node>>(n + 1){ mutableListOf() }.apply {
        arr.forEach { this[it[0]].add(Node(it[1], it[2])) }
    }
    val visited = BooleanArray(n + 1).apply { this[start] = true }

    graph[start].forEach{
        answer[it.index] = it.distance
    }

    for(i in 2..n){
        var now = getSmallestNode(answer, visited)
        visited[now] = true

        for(j in graph[now]){
            if(answer[now] + j.distance < answer[j.index])
                answer[j.index] = answer[now] + j.distance
        }
    }

    return answer.sliceArray(1..n)
}

// 우선순위 큐 사용 (이거로 외워)
private fun dijkstra2(n:Int, l:Int, start:Int, arr:Array<IntArray>):IntArray{
    data class Node(val index:Int, val distance:Int):Comparable<Node>{
        override fun toString():String{
            return "[${this.index}] : ${this.distance}\t"
        }

        override fun compareTo(other: Node): Int {
            return this.distance - other.distance
        }
    }

    val answer = IntArray(n + 1){INF}.apply { this[start] = 0 }
    val pq = PriorityQueue<Node>().apply{ offer(Node(start, 0)) }
    val graph = MutableList<MutableList<Node>>(n + 1){ mutableListOf() }.apply {
        arr.forEach { this[it[0]].add(Node(it[1], it[2])) }
    }

    while(pq.isNotEmpty()){
        val node = pq.poll()
        if(answer[node.index] < node.distance) continue
        for(nextNode in graph[node.index]) {
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
    dijkstra1(6,11,1,arr).forEach { print("${it}\t") }
    println()
    dijkstra2(6,11,1,arr).forEach { print("${it}\t") }
}