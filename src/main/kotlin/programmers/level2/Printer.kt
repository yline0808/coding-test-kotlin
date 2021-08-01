package programmers.level2

import java.util.PriorityQueue

/*
 * 문제 : 프린터
 * url : https://programmers.co.kr/learn/courses/30/lessons/42587
 * 유형 : 스택/큐
 */

private fun solution(priorities:IntArray, location:Int):Int{
    var answer = 0
    val pq = PriorityQueue<Int>(reverseOrder()).apply { priorities.forEach(::offer) }

    while (pq.isNotEmpty()){
        for(i in priorities.indices){
            if(pq.peek() == priorities[i]){
                pq.poll()
                answer++
                if(location == i){
                    pq.clear()
                    break
                }
            }
        }
    }

    return answer
}

private fun main(){
    println("1\n${solution(intArrayOf(2,1,3,2), 2)}\n")
    println("5\n${solution(intArrayOf(1,1,9,1,1,1), 0)}")
}