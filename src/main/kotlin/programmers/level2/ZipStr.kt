package programmers.level2

/*
 * 문제 : 문자열 압축
 * url : https://programmers.co.kr/learn/courses/30/lessons/60057
 * 유형 : 2020 KAKAO BLIND RECRUITMENT
 */

private fun solution(s:String): Int{
    var answer = s.length

    for(i in 1..(s.length / 2)){
        var zipLevel = 1
        var zipStr = s.substring(0,i)
        var result = ""

        for(j in i..s.length step i){
            if(zipStr == s.substring(j, if(j + i > s.length) s.length else j + i)) zipLevel++
            else{
                result += (if(zipLevel == 1) "" else zipLevel.toString()) + zipStr
                zipStr = s.substring(j, if(j + i > s.length) s.length else j + i)
                zipLevel = 1
            }
        }
        result += zipStr
        answer = answer.coerceAtMost(result.length)
    }

    return answer
}

private fun main(){
    println("7\n${solution("aabbaccc")}\n")
    println("9\n${solution("ababcdcdababcdcd")}\n")
    println("8\n${solution("abcabcdede")}\n")
    println("14\n${solution("abcabcabcabcdededededede")}\n")
    println("17\n${solution("xababcdcdababcdcd")}\n")
}