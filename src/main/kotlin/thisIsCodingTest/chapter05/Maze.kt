package thisIsCodingTest.chapter05

import java.util.Queue
import java.util.LinkedList

private fun solution(n:Int, m:Int, arr:Array<IntArray>):Int{
    val q:Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    val nc = arrayOf(0 to -1, 1 to 0, 0 to 1, -1 to 0)

    q.offer(0 to 0)
    while(q.isNotEmpty()){
        val now = q.poll()
        for(next in nc){
            val nx = now.first + next.first
            val ny = now.second + next.second

            if(nx in 0 until m && ny in 0 until n && arr[ny][nx] == 1){
                arr[ny][nx] = arr[now.second][now.first] + 1
                q.offer(nx to ny)
            }
        }
    }

    return arr[n-1][m-1]
}

private fun main(){
    val arr = arrayOf(
        intArrayOf( 1, 0, 1, 0, 1, 0 ),
        intArrayOf( 1, 1, 1, 1, 1, 1 ),
        intArrayOf( 0, 0, 0, 0, 0, 1 ),
        intArrayOf( 1, 1, 1, 1, 1, 1 ),
        intArrayOf( 1, 1, 1, 1, 1, 1 ))

    println("10\n${solution(5, 6, arr)}\n")

    arr.forEach{
        it.forEach{print("${it}\t")}
        println()
    }
}