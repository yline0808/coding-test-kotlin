package programmers.level2

/*
 * 문제 : 예상 대진표
 * url : https://programmers.co.kr/learn/courses/30/lessons/12985
 * 유형 : 2017 팁스타운
 */

private fun solution(n:Int, a:Int, b:Int):Int{
    var answer = 1
    var left = a.coerceAtMost(b)
    var right = a.coerceAtLeast(b)

    while(true){
        if(left % 2 != 0 && right == (left + 1)) break
        left = (left + 1) / 2
        right = (right + 1) / 2
        answer++
    }

    return answer
}

private fun bestSolution(n:Int, a:Int, b:Int):Int{
    return ((a - 1) xor (b - 1)).toString(2).length
}

private fun main(){
    println("3\n${solution(8,4,7)}")
    println(bestSolution(8,4,7))
}