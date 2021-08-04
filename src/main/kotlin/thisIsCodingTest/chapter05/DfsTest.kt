package thisIsCodingTest.chapter05

private fun dfs(graph:Array<IntArray>, v:Int, visited:BooleanArray){
    visited[v] = true
    print("${v}\t")
    for(i in graph[v]){
        if(!visited[i]) dfs(graph, i, visited)
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

    intArrayOf(1,2,7,6,8,3,4,5).forEach { print("${it}\t") }
    println()
    dfs(graph,1,BooleanArray(9))
}