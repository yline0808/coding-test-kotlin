package thisIsCodingTest.chapter03

private fun solution(n:Int, m:Int, arr:Array<IntArray>):Int{
    var answer = 0

    for(a in arr){
        answer = answer.coerceAtLeast(a.sorted()[0])
    }

    return answer
}

private fun main(){
    println("2\n${solution(3, 3, arrayOf(intArrayOf(3,1,2), intArrayOf(4,1,4), intArrayOf(2,2,2)))}\n")
    println("3\n${solution(2,4, arrayOf(intArrayOf(7,3,1,8), intArrayOf(3,3,3,4)))}\n")
}