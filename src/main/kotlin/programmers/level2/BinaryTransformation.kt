package programmers.level2

/*
 * 문제 : 이진 변환 반복하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/70129
 * 유형 : 월간 코드 챌린지 시즌1
 */

private fun solution(s:String):IntArray{
    val answer = IntArray(2){0}
    var str = s

    while(str != "1"){
        var cnt = 0
        str.map {if(it == '1')cnt++}
        answer[0]++
        answer[1] += str.length - cnt
        str = cnt.toString(2)
    }

    return answer
}

private fun bestSolution(s:String):IntArray{
    val answer = IntArray(2){0}
    var str = s

    while(str != "1"){
        answer[0]++
        answer[1] += str.replace("1", "").count()
        str = str.replace("0", "").count().toString(2)
    }

    return answer
}

private fun main(){
    println("${3}\t${8}")
    solution("110010101001").map { print("${it}\t") }
    println()
    bestSolution("110010101001").map { print("${it}\t") }
    println()

    println("${3}\t${3}")
    solution("01110").map { print("${it}\t") }
    println()
    bestSolution("01110").map { print("${it}\t") }
    println()

    println("${4}\t${1}")
    solution("1111111").map { print("${it}\t") }
    println()
    bestSolution("1111111").map { print("${it}\t") }
}