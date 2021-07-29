package programmers.level2

import java.lang.StringBuilder

/*
 * 제목 : 가장 큰 수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42746
 * 유형 : 정렬
 */

private fun solution(numbers:IntArray):String{
    val answer = StringBuilder()
//    이건 프로그래머스에서 안되는듯
//    numbers.sortedWith { num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2") }.forEach(answer::append)
    numbers.sortedWith(Comparator({num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2")})).forEach(answer::append)
    return answer.run { if (toString()[0] == '0') "0" else toString() }
}

private fun testSolution(numbers:IntArray):String{
//    이건 프로그래머스에서 안되는듯
//    return numbers.sortedWith { num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2") }.joinToString("").run { if (this[0] == '0') "0" else this }
    return numbers.sortedWith(Comparator({num1: Int, num2: Int -> "$num2$num1".compareTo("$num1$num2")})).joinToString("").run { if (this[0] == '0') "0" else this }
}

private fun main(){
    println("9534330\n${solution(intArrayOf(3, 30, 34, 5, 9))}")
    println("${testSolution(intArrayOf(3, 30, 34, 5, 9))}")
}