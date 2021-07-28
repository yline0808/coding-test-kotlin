package programmers.level2

/*
 * 문제 : 카펫
 * url : https://programmers.co.kr/learn/courses/30/lessons/42842
 * 유형 : 완전탐색
 */

private fun solution(brown:Int, yellow:Int):IntArray{
    return (1..yellow)
        .first { yellow % it == 0 && ((yellow / it + it) * 2 + 4) == brown }
        .let { intArrayOf(yellow / it + 2, it + 2) }
}

private fun main(){
    println("4\t3")
    solution(10, 2).map { print("${it}\t") }
    println("\n")

    println("3\t3")
    solution(8,1).map { print("${it}\t") }
    println("\n")

    println("8\t6")
    solution(24,24).map { print("${it}\t") }
}