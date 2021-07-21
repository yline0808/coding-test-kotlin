package programmers.level1

/*
 * 문제 : 정수 내림차순으로 배치하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12933
 * 유형 : 연습문제
 */

private fun solution(n:Long):Long{
    return String(n.toString().toCharArray().sortedArrayDescending()).toLong()
}

private fun main(){
    println(873211)
    println(solution(118372))
}