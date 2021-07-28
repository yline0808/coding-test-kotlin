package programmers.level2

import java.util.Queue
import java.util.LinkedList

/*
 * 문제 : 다리를 지나는 트럭
 * url : https://programmers.co.kr/learn/courses/30/lessons/42583
 * 유형 : 스택/큐
 */

private fun solution(bridge_length:Int, weight:Int, truck_weights:IntArray):Int{
    var answer = bridge_length
    val q:Queue<Int> = LinkedList()
    var max = 0

    for(w in truck_weights){
        while (true){
            if(q.isEmpty()) {
                q.offer(w)
                answer++
                max += w
                break
            }
            else if(q.size == bridge_length) {
                max -= q.poll()
            }
            else {
                if(max + w > weight){
                    q.offer(0)
                    answer++
                }else{
                    q.offer(w)
                    max += w
                    answer++
                    break
                }
            }
        }
    }

    return answer
}

private fun main(){
    println(8)
    println(solution(2,10, intArrayOf(7,4,5,6)))
    println()

    println(101)
    println(solution(100,100, intArrayOf(10)))
    println()

    println(110)
    println(solution(100,100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
}