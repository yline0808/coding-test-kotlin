package programmers.level1

import kotlin.math.sqrt

/*
 * 제목 : 소수 만들기
 * url : https://programmers.co.kr/learn/courses/30/lessons/12977
 * 유형 : Summer/Winter Coding(~2018)
 */

private fun isPrimeNumber(num :Int):Boolean{
    var cnt = 0

    for (i in 1..sqrt(num.toDouble()).toInt()){
        if(num % i == 0){
            cnt++
        }
    }
    return cnt == 1
}

private fun solution(nums:IntArray): Int{
    var answer = 0

    for(i in 0 until nums.size - 2){
        for(j in (i + 1) until nums.size - 1){
            for(k in (j + 1) until nums.size){
                if(isPrimeNumber(nums[i] + nums[j] + nums[k])){
                    answer++
                }
            }
        }
    }

    return answer
}

private fun main(){
    println(4)
    println(solution(intArrayOf(1,2,7,6,4)))
}