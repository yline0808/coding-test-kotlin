package thisIsCodingTest.chapter11

private fun solution(n:Int, arr:IntArray):Int{
    var answer = 1

    arr.sorted().forEach {
        if(answer < it) return@forEach
        answer += it
    }

    return answer
}

private fun main(){
    println("8\n${solution(5, intArrayOf(3,2,1,1,9))}")
}