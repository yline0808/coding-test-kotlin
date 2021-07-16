package programmers.level1

import java.util.Stack

/*
 * 제목 : 크레인 인형뽑기 게임
 * url : https://programmers.co.kr/learn/courses/30/lessons/64061
 * 유형 : 2019카카오 개발자 겨울 인턴십
 */

fun solution(board: Array<IntArray>, moves: IntArray):Int{
    var answer = 0
    val stack = Stack<Int>()

    for(m in moves){
        for(b in board){
            if (b[m - 1] != 0){
                if(!stack.isEmpty() && stack.peek() == b[m - 1]){
                    answer+=2
                    stack.pop()
                }else{
                    stack.push(b[m - 1])
                }
                b[m - 1] = 0
                break
            }
        }
    }

    return answer
}

fun main(){
    val board = arrayOf(
        intArrayOf( 0, 0, 0, 0, 0 ),
        intArrayOf( 0, 0, 1, 0, 3 ),
        intArrayOf( 0, 2, 5, 0, 1 ),
        intArrayOf( 4, 2, 4, 4, 2 ),
        intArrayOf( 3, 5, 1, 3, 1 ))
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)

    println(4)
    println(solution(board, moves))
}