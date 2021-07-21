package programmers.level1

/*
 * 문제 : 같은 숫자는 싫어
 * url : https://programmers.co.kr/learn/courses/30/lessons/12906
 * 유형 : 연습문제
 */

private fun solution(arr:IntArray): IntArray{
    val result = arrayListOf<Int>(arr[0])
    for(i in 1 until arr.size){
        if(arr[i - 1] != arr[i]){
            result.add(arr[i])
        }
    }
    return result.toIntArray()
}

private fun main(){
    intArrayOf(1,3,0,1).map(::print)
    println()
    solution(intArrayOf(1,1,3,3,0,1,1)).map(::print)
    println()
    intArrayOf(4,3).map(::print)
    println()
    solution(intArrayOf(4,4,4,3,3)).map(::print)
}