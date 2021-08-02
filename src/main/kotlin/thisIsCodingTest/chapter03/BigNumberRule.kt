package thisIsCodingTest.chapter03

private fun solution1(n:Int, m:Int, k:Int, arr:IntArray):Int{
    return arr.sortedDescending().run { this[0] * ((m / (k + 1)) * k + (m % (k + 1))) + this[1] * (m / (k + 1)) }
}

private fun solution2(n:Int, m:Int, k:Int, arr:IntArray):Int{
    var answer = 0

    arr.sortDescending()

    var cnt = 0

    while (cnt <= m){
        for(i in 1..k){
            if(cnt >= m) break
            answer += arr[0]
            cnt++
        }
        if(cnt >= m) break
        answer += arr[1]
        cnt++
    }

    return answer
}

private fun main(){
    println("46\n${solution1(5,8,3, intArrayOf(2,4,5,4,6))}")
    println(solution2(5,8,3, intArrayOf(2,4,5,4,6)))
}