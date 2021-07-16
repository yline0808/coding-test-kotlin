package programmers.level1

import kotlin.math.sqrt

/*
 * 제목 : 약수의 개수와 덧셈
 * url : https://programmers.co.kr/learn/courses/30/lessons/77884?language=java
 * 유형 : 월간 코드 챌린지 시즌2
 *
 * 참고 : 자연수가 제곱수라면 그 수의 약수는 홀수개, 아니면 짝수개
 */

fun solution(left: Int, right: Int): Int{
    var answer = 0

    for(i in left .. right){
        answer += if(sqrt(i.toDouble()) % 1 == 0.toDouble()) -i else i
    }

    return answer
}

fun main(){
    println(43)
    println(solution(13,17))
}