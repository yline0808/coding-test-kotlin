package programmers.level2


/*
 * 문제 : 오픈채팅방
 * url : https://programmers.co.kr/learn/courses/30/lessons/42888
 * 유형 : 2019 KAKAO BLIND RECRUITMENT
 */

private fun solution(record:Array<String>):Array<String>{
    val hm = HashMap<String, String>().apply {
        for(r in record){
            val str = r.split(" ")
            if(str[0] == "Enter" || str[0] == "Change"){
                this[str[1]] = str[2]
            }
        }
    }

    val answer = mutableListOf<String>()

    for(r in record){
        val str = r.split(" ")
        if(str[0] != "Change")
            answer.add("${hm[str[1]]}님이 ${if(str[0] == "Enter") "들어왔" else "나갔"}습니다.")
    }

    return answer.toTypedArray()
}

private fun main(){
    println("${arrayOf("Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다.").map { "${it}\t" }}\n")
    println("${solution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan")).map { "${it}\t" }}")
}