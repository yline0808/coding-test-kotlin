package thisIsCodingTest.chapter11

private fun solution(num:Int, m:Int, arr:IntArray):Int{
    var answer = 0
    var n = num
    val bollList = IntArray(m + 1).apply { arr.forEach { this[it]++ } }

    for(i in 1..m){
        n -= bollList[i]
        answer += bollList[i] * n
    }

    return answer
}

private fun main(){
    println("8\n${solution(5,3,intArrayOf(1,3,2,3,2))}")
    println("25\n${solution(8,5,intArrayOf(1,5,4,3,2,4,5,2))}")
}