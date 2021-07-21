package programmers.level1

private fun solution(n:Int):Int{
    return StringBuffer(n.toString(3)).reverse().toString().toInt(3)
}

private fun main(){
    println(7)
    println(solution(45))

    println(229)
    println(solution(125))
}