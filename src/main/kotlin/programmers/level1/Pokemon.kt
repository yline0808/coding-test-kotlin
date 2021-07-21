package programmers.level1

/*
 * 문제 : 포켓몬
 * url : https://programmers.co.kr/learn/courses/30/lessons/1845
 * 유형 : 찾아라 프로그래밍 마에스터
 */

private fun solution(nums:IntArray): Int{
    var answer = nums.size / 2
    val hs = HashSet<Int>(nums.asList())
    return if (answer > hs.size) hs.size else answer
}

private fun main(){
    println(3)
    println(solution(intArrayOf(3,3,3,2,2,4)))
}