package thisIsCodingTest.chapter08

private fun solution(n:Int, m:Int, arr:IntArray):Int{
    val d = IntArray(m + 1){10001}.apply{this[0] = 0}

    for(i in arr){
        for(j in i..m){
            if(d[j] - i != 10001) d[j] = d[j].coerceAtMost(d[j - i] + 1)
        }
    }

    return if(d[m] == 10001) -1 else d[m]
}

private fun main(){
    println("5\n${solution(2,15, intArrayOf(2,3))}\n")
    println("-1\n${solution(3,4, intArrayOf(3,5,7))}")
}