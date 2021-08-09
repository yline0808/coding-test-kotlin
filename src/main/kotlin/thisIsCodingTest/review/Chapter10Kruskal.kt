package thisIsCodingTest.review

private fun findParent(x:Int, parent:IntArray):Int{
    if(x != parent[x]) parent[x] = findParent(parent[x], parent)
    return parent[x]
}

private fun unionParent(a:Int, b:Int, parent:IntArray){
    val ap = findParent(a, parent)
    val bp = findParent(b, parent)
    if(ap < bp) parent[bp] = ap else parent[ap] = bp
}

private fun solution(n:Int, v:Int, arr:Array<IntArray>):Int{
    data class Edge(val nodeA:Int, val nodeB:Int, val distance:Int):Comparable<Edge>{
        override fun compareTo(other:Edge):Int{
            return this.distance - other.distance
        }
    }

    var answer = 0
    val parent = IntArray(n + 1){it}
    val edges = mutableListOf<Edge>().apply { arr.forEach { add(Edge(it[0], it[1], it[2])) } }.sorted()

    for(e in edges){
        if(findParent(e.nodeA, parent) != findParent(e.nodeB, parent)){
            unionParent(e.nodeA, e.nodeB, parent)
            answer += e.distance
        }
    }

    return answer
}

private fun main(){
    val arr = arrayOf(
        intArrayOf(1,2,29), intArrayOf(1,5,75), intArrayOf(2,3,35),
        intArrayOf(2,6,34), intArrayOf(3,4,7), intArrayOf(4,6,23),
        intArrayOf(4,7,13), intArrayOf(5,6,53), intArrayOf(6,7,25))
    println("159\n${solution(7,9,arr)}")
}