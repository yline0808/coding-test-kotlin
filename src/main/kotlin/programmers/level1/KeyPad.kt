package programmers.level1

import kotlin.math.abs

/*
 * 제목 : 키패드 누르기
 * url : https://programmers.co.kr/learn/courses/30/lessons/67256
 * 유형 : 2020 카카오 인턴십
 */

private fun setCoordinate(num:Int):IntArray{
    return intArrayOf((num - 1) / 3, (num - 1) % 3)
}

private fun solution(numbers: IntArray, hand: String): String{
    val answer = StringBuilder()

    var left = intArrayOf(3,0)
    var right = intArrayOf(3,2)

    for(i in numbers.indices){
        if(numbers[i] == 0) numbers[i] = 11
        when{
            numbers[i] % 3 == 1 -> {
                answer.append("L")
                left = setCoordinate(numbers[i])
            }
            numbers[i] % 3 == 0 -> {
                answer.append("R")
                right = setCoordinate(numbers[i])
            }
            else -> {
                val leftDist = abs(left[0] - (numbers[i] - 1) /3) + abs(left[1] - (numbers[i] - 1) % 3)
                val rightDist = abs(right[0] - (numbers[i] - 1) / 3) + abs(right[1] - (numbers[i] - 1) %3)
                if(leftDist == rightDist){
                    if(hand == "left"){
                        answer.append("L")
                        left = setCoordinate(numbers[i])
                    }else{
                        answer.append("R")
                        right = setCoordinate(numbers[i])
                    }
                }else{
                    if(leftDist < rightDist){
                        answer.append("L")
                        left = setCoordinate(numbers[i])
                    }else{
                        answer.append("R")
                        right = setCoordinate(numbers[i])
                    }
                }
            }
        }
    }

    return answer.toString()
}

private fun main(){
    println("LLRLLRLLRL")
    println(solution(intArrayOf(1,2,3,4,5,6,7,8,9,0), "right"))
}