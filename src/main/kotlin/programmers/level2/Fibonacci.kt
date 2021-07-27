package programmers.level2

/*
 * 제목 : 피보나치 수
 * url : https://programmers.co.kr/learn/courses/30/lessons/12945
 * 유형 : 연습문제
 */

private fun solution(n: Int): Int {
    val arr = IntArray(n + 1){1}
    if(n <= 2) return 1
    (3..n).map { arr[it] = arr[it - 2] + arr[it - 1] % 1234567 }
    return arr[n]
}

private fun main(){
    println(2)
    println(solution(3))
    println(5)
    println(solution(5))
}