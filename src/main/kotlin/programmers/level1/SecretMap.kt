package programmers.level1

/*
 * 문제 : [1차] 비밀지도
 * url : https://programmers.co.kr/learn/courses/30/lessons/17681
 * 유형 : 2018 KAKAO BLIND RECRUITMENT
 */

private fun solution(n: Int, arr1: IntArray, arr2: IntArray): Array<String> {
    return Array(n) { "%${n}s".format((arr1[it] or arr2[it]).toString(2)).replace("1", "#").replace("0", " ") }
}

private fun main(){
    arrayOf("#####", "# # #", "### #", "#  ##", "#####").map(::print)
    println()
    solution(5, intArrayOf(9, 20, 28, 18, 11), intArrayOf(30, 1, 21, 17, 28)).map(::print)
    println()

    arrayOf("######", "###  #", "##  ##", " #### ", " #####", "### # ").map(::print)
    println()
    solution(6, intArrayOf(46, 33, 33, 22, 31, 50), intArrayOf(27, 56, 19, 14, 14, 10)).map(::print)
    println()

    arrayOf("#### ", "    #", "# # #", "#   #", "###  ").map(::print)
    println()
    solution(5, intArrayOf(0, 0, 0, 0, 0), intArrayOf(30, 1, 21, 17, 28)).map(::print)
    println()
}