package programmers.level2

/*
 * 문제 : 조이스특
 * url : https://programmers.co.kr/learn/courses/30/lessons/42860
 * 유형 : 탐욕법(Greedy)
 */

private fun solution(name:String):Int{
    var answer = 0
    var min = name.length - 1

    for(i in name.indices){
        answer += if(name[i] - 'A' < 'Z' - name[i] + 1) (name[i] - 'A') else ('Z' - name[i] + 1)

        var nextIndex = i + 1
        while (nextIndex < name.length && name[nextIndex] == 'A')
            nextIndex++

        min = min.coerceAtMost(i * 2 + name.length - nextIndex)
    }
    return answer + min
}

private fun main(){
    println("56\n${solution("JEROEN")}\n")
    println("23\n${solution("JAN")}\n")
}