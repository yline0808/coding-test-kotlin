package programmers.level1

/*
 * 제목 : 내적
 * url : https://programmers.co.kr/learn/courses/30/lessons/70128
 * 유형 : 월간 코드 챌린지 시즌1
 */

private fun solution(a:IntArray, b:IntArray):Int{
    var answer = 0
    for(i in a.indices) answer+=a[i] * b[i]
    return answer
}

private fun main(){
    println(3)
    println(solution(intArrayOf(1,2,3,4), intArrayOf(-3,-1,0,2)))
}