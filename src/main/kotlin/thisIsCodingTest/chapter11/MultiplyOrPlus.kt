package thisIsCodingTest.chapter11

private fun solution(s:String):Int{
    var answer:Int = s[0].toString().toInt()

    for(i in 1 until s.length){
        answer = (answer + s[i].toString().toInt()).coerceAtLeast(answer * s[i].toString().toInt())
    }

    return answer
}

private fun main(){
    println("576\n${solution("02984")}")
    println("\n210\n${solution("567")}")
}