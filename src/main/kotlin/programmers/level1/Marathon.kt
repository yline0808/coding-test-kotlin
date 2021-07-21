package programmers.level1

/*
 * 제목 : 완주하지 못한 선수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 유형 : 해시
 */

fun solution(participant: Array<String>, completion: Array<String>):String{
    val hm = HashMap<String, Int>()

    participant.map { hm.put(it, hm.getOrDefault(it, 0) + 1) }
    completion.map { hm.put(it, hm.get(it) - 1) }
    hm.entries.map { it.value != 0 return it.key }
}

fun main(){
    println("mislav")
    println(solution(arrayOf("mislav", "stanko", "mislav", "ana"), arrayOf("stanko", "ana", "mislav")))
}