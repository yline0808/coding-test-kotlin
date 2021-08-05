package thisIsCodingTest.chapter08

private fun solution(n:Int, arr:IntArray):Int{
    var answer = 0
    val d = IntArray(n)

    d[0] = arr[0]
    for(i in 2 until n){
        d[i] = arr[i - 1].coerceAtLeast(arr[i] + arr[i - 2])
    }

    return d[n-1]
}

private fun main(){
    println("8\n${solution(4, intArrayOf(1,3,1,5))}")
    println("5\n${solution(1, intArrayOf(5))}")
}