package programmers.level2

/*
 * 문제 : 큰 수 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/42883
 * 유형 : 탐욕법
 *
 *          for     foreach     map
 *  시간    빠름    느림        느림
 *  용량    적음    적음        많음
 *
 * for로 쓰는게 좋은듯
 */

private fun solution(number:String, k:Int): String{
    val answer = StringBuilder()
    var idx = 0
    (0 until number.length - k).forEach { i ->
        var max = '0'
        (idx..k + i).forEach {
            if(max < number[it]){
                max = number[it]
                idx = it + 1
            }
        }
        answer.append(max)
    }
    return answer.toString()
}

private fun bestSolution(number:String, k:Int):String{
    var idx = 0
    val answer = StringBuilder()

    for(i in 0 until number.length - k){
        var max = '0'
        for(j in idx..i + k){
            if(max < number[j]){
                max = number[j]
                idx = j + 1
            }
        }
        answer.append(max)
    }

    return answer.toString()
}

private fun main(){
    println(94)
    println(solution("1924", 2))
    println(bestSolution("1924", 2))
    println()

    println(3234)
    println(solution("1231234", 3))
    println(bestSolution("1231234", 3))
    println()

    println(775841)
    println(solution("4177252841", 4))
    println(bestSolution("4177252841", 4))
}