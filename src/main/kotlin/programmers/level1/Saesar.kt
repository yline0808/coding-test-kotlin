package programmers.level1

/*
 * 문제 : 시저 암호
 * url : https://programmers.co.kr/learn/courses/30/lessons/12926
 * 유형 : 연습문제
 */

private fun solution(s:String, n:Int):String{
    val sb = StringBuilder()

    for(c in s){
        when (c) {
            in 'a'..'z' -> sb.append(if (c + n > 'z') c + n - 26 else c + n )
            in 'A'..'Z' -> sb.append(if (c + n > 'Z') c + n - 26 else c + n )
            else -> sb.append(c)
        }
    }
    return sb.toString()
}

private fun main(){
    println("BC")
    println(solution("AB", 1))
    println("a")
    println(solution("z", 1))
    println("e F d")
    println(solution("a B z", 4))
}