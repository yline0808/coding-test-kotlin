package thisIsCodingTest.chapter05

import java.util.Queue
import java.util.LinkedList

/*
 * 왜 dfs인지 모르겠음.. bfs로도 풀 수 있는데
 * 아마 재귀함수로 간단히 구현이 가능해서 dfs를 사용하는듯
 */

private fun dfs(graph:Array<IntArray>, x:Int, y:Int):Boolean{
    return if(x in 0 until graph[0].size && y in graph.indices && graph[y][x] == 0){
        graph[y][x] = 1
        dfs(graph, x + 1, y)
        dfs(graph, x - 1, y)
        dfs(graph, x, y + 1)
        dfs(graph, x, y - 1)
        true
    }else false
}

private fun solution(graph:Array<IntArray>):Int{
    var answer = 0

    for(i in graph.indices){
        for(j in graph[i].indices){
            if(dfs(graph, j, i)) answer++
        }
    }

    return answer
}

private fun bfs(graph:Array<IntArray>, x:Int, y:Int){
    val q:Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    val dc = arrayOf(0 to -1, 1 to 0, 0 to 1, -1 to 0)
    q.offer(x to y)

    while (q.isNotEmpty()){
        val now = q.poll()
        for(i in dc){
            val nx = now.first - i.first
            val ny = now.second - i.second

            if(nx in 0 until graph[0].size && ny in graph.indices && graph[ny][nx] == 0){
                q.offer(nx to ny)
                graph[ny][nx] = 1
            }
        }
    }
}

private fun bfsTest(graph:Array<IntArray>):Int{
    var answer = 0

    for(i in graph.indices){
        for(j in graph[i].indices){
            if(graph[i][j] == 0){
                bfs(graph, j, i)
                answer++
            }
        }
    }
    return answer
}

private fun main(){
    val graph1 = arrayOf(
        intArrayOf(0,0,1,1,0),
        intArrayOf(0,0,0,1,1),
        intArrayOf(1,1,1,1,1),
        intArrayOf(0,0,0,0,0)
    )

    val graph2 = arrayOf(
        intArrayOf( 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 ), intArrayOf( 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0 ),
        intArrayOf( 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 ), intArrayOf( 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 ),
        intArrayOf( 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ), intArrayOf( 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 ),
        intArrayOf( 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 ), intArrayOf( 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ),
        intArrayOf( 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 ), intArrayOf( 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 ),
        intArrayOf( 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 ), intArrayOf( 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 ),
        intArrayOf( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1 ), intArrayOf( 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 ),
        intArrayOf( 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 )
    )

    println("3\n${solution(graph1.map{it.copyOf()}.toTypedArray())}\n")
    println("8\n${solution(graph2.map{it.copyOf()}.toTypedArray())}\n")

    println("3\n${bfsTest(graph1.map{it.copyOf()}.toTypedArray())}\n")
    println("8\n${bfsTest(graph2.map{it.copyOf()}.toTypedArray())}\n")
}