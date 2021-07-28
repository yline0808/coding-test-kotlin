package programmers.level2

/*
 * 문제 : H-Index
 * url : https://programmers.co.kr/learn/courses/30/lessons/42747
 * 유형 : 정렬
 *
 * 참고 : 문제가 모르겠고 이건 안나올듯
 */

private fun solution(citations: IntArray):Int{
    var answer = 0
    citations.sort()
    for(i in citations.indices){
        answer = answer.coerceAtLeast(citations[i].coerceAtMost(citations.size - i))
    }

    return answer
}

private fun main(){
    println(3)
    println(solution(intArrayOf(3,0,6,1,5)))
}