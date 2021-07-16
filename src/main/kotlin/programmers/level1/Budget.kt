package programmers.level1

/*
 * 문제 : 예산
 * url : https://programmers.co.kr/learn/courses/30/lessons/12982
 * 유형 : Summer/Winter Coding(~2018)
 */

fun solution(d: IntArray, budget:Int): Int{
    var answer = 0

    d.sort()
    var sum = 0

    for(i in d){
        sum+= i
        if(sum > budget) break
        answer++
    }

    return answer
}

fun main(){
    val d = intArrayOf(1, 3, 2, 5, 4)

    println(3)
    println(solution(d,9))
}