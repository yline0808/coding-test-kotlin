package programmers.level2

import java.util.PriorityQueue

/*
 * 문제 : 배달
 * url : https://programmers.co.kr/learn/courses/30/lessons/12978
 * 유형 : Summer/Winter Coding(~2018)
 */

private fun solution(n:Int, road:Array<IntArray>, k:Int):Int{
    val town = IntArray(n + 1){500001}.apply { this[1] = 0 }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { add(1 to 0) }

    while(pq.isNotEmpty()){
        var (now, dist) = pq.poll()
        if(dist > town[now]) continue
        for(i in road.indices){
            val cost = road[i][2] + dist
            if(road[i][0] == now){
                val idx = road[i][1]
                if(cost < town[idx]){
                    town[idx] = cost
                    pq.add(idx to cost)
                }
            }else if(road[i][1] == now){
                val idx = road[i][0]
                if(cost < town[idx]){
                    town[idx] = cost
                    pq.add(idx to cost)
                }
            }
        }
    }

    return town.fold(0){acc, i -> acc + if(i <= k) 1 else 0 }
}

private fun main(){
    println(4)
    println(solution(5, arrayOf(intArrayOf( 1, 2, 1 ), intArrayOf( 2, 3, 3 ), intArrayOf( 5, 2, 2 ), intArrayOf( 1, 4, 2 ), intArrayOf( 5, 3, 1 ), intArrayOf( 5, 4, 2 )), 3))
    println()

    println(4)
    println(solution(6, arrayOf(intArrayOf( 1, 2, 1 ), intArrayOf( 1, 3, 2 ), intArrayOf( 2, 3, 2 ), intArrayOf( 3, 4, 3 ), intArrayOf( 3, 5, 2 ), intArrayOf( 3, 5, 3 ), intArrayOf( 5, 6, 1 )), 4))
}