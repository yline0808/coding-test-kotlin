package thisIsCodingTest.chapter12

private fun solution(s:String):String{
    var answer = ""
    var num = 0
    s.forEach { if(it.isDigit()) num += it - '0' else answer += it }

    return answer.toCharArray().sorted().joinToString("") + num
}

private fun main(){
    println("ABCKK13\n${solution("K1KA5CB7")}")
    println("ADDIJJJKKLSS20\n${solution("AJKDLSI412K4JSJ9D")}")
}