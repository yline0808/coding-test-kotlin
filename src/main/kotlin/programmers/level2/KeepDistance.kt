package programmers.level2

/*
 * 문제 : 거리두기 확인하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/81302
 * 유형 : 2021 카카오 채용연계형 인턴십
 */

private fun solution(places:Array<Array<String>>):IntArray{
    var answer = IntArray(5)



    return answer
}

private fun main(){
    intArrayOf(1, 0, 1, 1, 1).forEach { print("${it}\t") }
    println()
    solution(arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"), arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"), arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"))
    ).forEach { print("${it}\t") }
}