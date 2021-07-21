package programmers.level1

/*
 * 문제 : 직사각형 별찍기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12969
 * 유형 : 연습문제
 */

private fun solution(a:Int, b:Int){
    (0 until b).map {
        (0 until a).map { print("*") }
        println()
    }
}

private fun main(){
    (0..2).map{ println("*****")}
    println()
    solution(5,3)
}