package programmers.level2

import java.util.*

/*
 * 제목 : 기능개발
 * url : https://programmers.co.kr/learn/courses/30/lessons/42586
 * 유형 : 스택/큐
 */

private fun solution(progresses:IntArray, speeds: IntArray): IntArray{
    var answer = mutableListOf<Int>()
    val q:Queue<Int> = LinkedList<Int>().apply {
        progresses.forEachIndexed { index, i ->
            this.offer((100 - i) / speeds[index] + if((100 - i) % speeds[index] == 0) 0 else 1 )
        }
    }

    var start = q.poll()
    var count = 1

    while(q.isNotEmpty()){
        if(start >= q.poll()) count++
        else{
            answer.add(count)
            count = 1
        }
    }

    return answer.apply { add(count) }.toIntArray()
}

private fun main(){
    println("2\t1\n${solution(intArrayOf(93,30,55), intArrayOf(1,30,5)).map { "${it}\t" }}")
}