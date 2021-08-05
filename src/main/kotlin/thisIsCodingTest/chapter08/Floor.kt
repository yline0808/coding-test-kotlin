package thisIsCodingTest.chapter08

import kotlin.math.pow

private fun solution(n:Int):Int{
    val d = IntArray(n+1)

    d[1] = 1
    d[2] = 3

    for(i in 3..n){
        d[i] = (d[i-1] + d[i - 2] * 2) % 796796
    }

    return d[n]
}

private fun main(){
    println("5\n${solution(3)}")
}