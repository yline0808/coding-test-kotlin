package programmers.level2

/*
 * 문제 : JadenCase 문자열 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12951
 * 유형 : 연습문제
 */

private fun solution(s:String): String{
    return s.lowercase().split(' ').joinToString(" "){it.capitalize()}
}

private fun main(){
    println("3people Unfollowed Me")
    println(solution("3people unFollowed me"))
    println("For The Last Week")
    println(solution("for the last week"))
}