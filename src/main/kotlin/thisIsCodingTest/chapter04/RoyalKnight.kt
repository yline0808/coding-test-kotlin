package thisIsCodingTest.chapter04

private fun solution(s:String):Int{
    var answer = 0

    var x:Int = s[0].hashCode() - ('a' - 1).toInt()
    var y:Int = s[1].digitToInt()
    val dx = intArrayOf(1,2,2,1,-1,-2,-2,-1)
    val dy = intArrayOf(-2,-1,1,2,2,1,-1,-2)

    for(i in dx.indices){
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx in 1..8 && ny in 1..8) answer++
    }

    return answer
}

private fun main(){
    println("2\n${solution("a1")}\n")
    println("6\n${solution("c2")}\n")
}