package programmers.level2

/*
 * 문제 : 최댓값과 최솟값
 * url : https://programmers.co.kr/learn/courses/30/lessons/12939
 * 유형 : 연습문제
 */

private fun solution(s:String): String{
    val answer = s.split(' ').map { it.toInt() }.sorted()
    return answer[0].toString() + " " + answer[answer.size - 1].toString()
}

private fun bestSolution(s:String): String = s.split(' ').map{it.toInt()}.let { "${it.minOrNull()} ${it.maxOrNull()}" }

private fun main(){
    println("-4 -1")
    println(solution("-1 -2 -3 -4"))
    println(bestSolution("-1 -2 -3 -4"))
}