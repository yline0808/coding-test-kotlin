package programmers.level2

import kotlin.math.log2

/*
 * 문제 : 쿼드 압축 후 개수 세기
 * url : https://programmers.co.kr/learn/courses/30/lessons/68936
 * 유형 : 월간 코드 챌린지 시즌 1
 * 1 1 log1+1 1
 * 2 2 log2+1 2
 * 4 3 log4+1 3
 * 8 4 log8+1 4
 * 16 5
 * 32 6
 */

private fun solution(arr: Array<IntArray>): IntArray{
    val answer: IntArray = intArrayOf(0, 0)
    var idx = arr.size

    for(i in 0..log2(arr.size.toFloat()).toInt()){
        for(i in arr.size downTo 1 step idx){
            println(i)
        }
    }


    return answer
}

private fun main(){
    println("4\t9")
    solution(arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))).map { print("${it}\t") }

    println("\n\n10\t5")
    solution(arrayOf(
        intArrayOf(1,1,1,1,1,1,1,1), intArrayOf(0,1,1,1,1,1,1,1),
        intArrayOf(0,0,0,0,1,1,1,1), intArrayOf(0,1,0,0,1,1,1,1),
        intArrayOf(0,0,0,0,0,0,1,1), intArrayOf(0,0,0,0,0,0,0,1),
        intArrayOf(0,0,0,0,1,0,0,1), intArrayOf(0,0,0,0,1,1,1,1))).map { print("${it}\t") }
}