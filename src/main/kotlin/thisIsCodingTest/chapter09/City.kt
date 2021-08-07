package thisIsCodingTest.chapter09

private fun solution(n:Int, m:Int, arr:Array<IntArray>, x:Int, k:Int):Int{
    val graph = Array<IntArray>(n){IntArray(n){ 1e9.toInt()} }.apply {
        arr.forEach {
            this[it[0]-1][it[1]-1] = 1
            this[it[1]-1][it[0]-1] = 1
        }
        (0 until n).forEach{this[it][it] = 0}
    }

    for(i in 0 until n){
        for(j in 0 until n){
            for(l in 0 until n){
                graph[j][l] = graph[j][l].coerceAtMost(graph[j][i] + graph[i][l])
            }
        }
    }

    return if(graph[0][k-1] + graph[k-1][x-1] < 1e9.toInt()) graph[0][k-1] + graph[k-1][x-1] else -1
}

private fun main(){
    val arr1 = arrayOf(
        intArrayOf( 1, 2 ), intArrayOf( 1, 3 ), intArrayOf( 1, 4 ), intArrayOf( 2, 4 ),
        intArrayOf( 3, 4 ), intArrayOf( 3, 5 ), intArrayOf( 4, 5 ))
    val arr2 = arrayOf(
        intArrayOf(1,3),
        intArrayOf(2,4)
    )
    println("3\n${solution(5,7,arr1,4,5)}\n")
    println("-1\n${solution(4,2,arr2,3,4)}")
}