package thisIsCodingTest.chapter07

private fun solution(n:Int, m:Int, arr:IntArray):Int{
    var answer = 0
    var start = 0
    var end = 1e9.toInt()

    while(start <= end){
        val mid = (start + end) / 2
        var total = 0
        for(i in 0 until n){
            total += if(mid < arr[i]) arr[i] - mid else 0
        }
        if(total < m) end = mid - 1
        else{
            answer = mid
            start = mid + 1
        }
    }

    return answer
}

private fun main(){
    println("15\n${solution(4,6,intArrayOf(19,15,10,17))}")
}