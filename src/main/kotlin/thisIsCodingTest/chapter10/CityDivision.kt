package thisIsCodingTest.chapter10

import java.util.PriorityQueue

// 크루스칼 알고리즘

private fun findParent(x:Int, parent:IntArray):Int{
    if(x != parent[x]) parent[x] = findParent(parent[x], parent)
    return parent[x]
}

private fun unionParent(a:Int, b:Int, parent:IntArray){
    val ap = findParent(a, parent)
    val bp = findParent(b, parent)
    if(ap < bp) parent[bp] = ap else parent[ap] = bp
}

private fun solution(n:Int, m:Int, arr:Array<IntArray>):Int{
    data class Edge(val nodeA:Int, val nodeB :Int, val distance:Int):Comparable<Edge>{
        override fun toString():String{
            return "[${nodeA} -> ${nodeB}] : ${distance}\t"
        }

        override fun compareTo(other:Edge):Int{
            return this.distance - other.distance
        }
    }

    var answer = 0
    val parent = IntArray(n + 1){it}
    val pq = PriorityQueue<Edge>().apply { arr.forEach { offer(Edge(it[0], it[1], it[2])) } }
    var last = 0
    while(pq.isNotEmpty()){
        val now = pq.poll()
        if(findParent(now.nodeA, parent) != findParent(now.nodeB, parent)){
            println("${now}")
            unionParent(now.nodeA, now.nodeB, parent)
            answer += now.distance
            last = now.distance
        }else println("\t\t\t${now}")
    }

    return answer - last
}

private fun main(){
    val arr = arrayOf(
        intArrayOf(1,2,3), intArrayOf(1,3,2), intArrayOf(3,2,1), intArrayOf(2,5,2),
        intArrayOf(3,4,4), intArrayOf(7,3,6), intArrayOf(5,1,5), intArrayOf(1,6,2),
        intArrayOf(6,4,1), intArrayOf(6,5,3), intArrayOf(4,5,3), intArrayOf(6,7,4))
    println("8\n${solution(7,12,arr)}")
}