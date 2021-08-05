package thisIsCodingTest.chapter08

private fun solution(x:Int):Int{
    val d = IntArray(x+1)

    for(i in 2..x){
        d[i] = d[i - 1] + 1
        if(i % 2 == 0) d[i] = d[i].coerceAtMost(d[i / 2] + 1)
        if(i % 3 == 0) d[i] = d[i].coerceAtMost(d[i / 3] + 1)
        if(i % 5 == 0) d[i] = d[i].coerceAtMost(d[i / 5] + 1)
    }

    return d[x]
}

private fun main(){
    println("3\n${solution(26)}")
}