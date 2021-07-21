package programmers.level1

import kotlin.math.sqrt

/*
 * 제목 : 약수의 개수와 덧셈
 * url : https://programmers.co.kr/learn/courses/30/lessons/77884
 * 유형 : 월간 코드 챌린지 시즌2
 *
 * 참고 : 자연수가 제곱수라면 그 수의 약수는 홀수개, 아니면 짝수개
 */

private fun solution(left: Int, right: Int): Int{
    var answer = 0

    for(i in left .. right){
        answer += if(sqrt(i.toDouble()) % 1 == 0.toDouble()) -i else i
    }

    return answer
}

private fun otherSolution(left: Int, right: Int): Int{
    return (left..right).map { if (sqrt(it.toDouble()) % 1 == 0.toDouble()) -it else it }.sum()

//    밑에꺼는 프로그래머스에서 sumOf를 지원 안하는듯
//    return (left..right).sumOf { if (sqrt(it.toDouble()) % 1 == 0.toDouble()) -it else it }
}

private fun main(){
    println(43)
    println(solution(13,17))
    println(otherSolution(13, 17))
}