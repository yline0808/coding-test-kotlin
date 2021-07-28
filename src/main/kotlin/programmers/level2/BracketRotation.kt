package programmers.level2

import java.util.Stack

/*
 * 문제 : 괄호 회전하기
 * url : https://programmers.co.kr/learn/courses/30/lessons/76502
 * 유형 : 월간 코드 챌린지 시즌2
 */

private fun isTrue(s:String):Boolean{
    val openBracket = charArrayOf('(', '{', '[')
    val closeBracket = charArrayOf(')', '}', ']')
    val stack = Stack<Char>()
    var flag = false

    for(c in closeBracket)
        if(s[0] == c)
            return false

    for(c in s){
        flag = false
        for(i in openBracket.indices)
            if(stack.isNotEmpty() && stack.peek() == openBracket[i] && c == closeBracket[i])
                flag = true

        if(flag) stack.pop()
        else stack.add(c)
    }

    return stack.isEmpty()
}

private fun solution(s:String) = s.indices.count { isTrue(s.substring(it, s.length) + s.substring(0, it)) }

private fun main(){
    println(3)
    println(solution("[](){}"))
}