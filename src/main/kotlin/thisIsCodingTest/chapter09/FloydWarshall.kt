package thisIsCodingTest.chapter09

private fun solution(n:Int, l:Int, arr:Array<IntArray>):Array<IntArray>{
    val answer = Array<IntArray>(n){ IntArray(n){1e9.toInt()} }.apply{
        arr.forEach { this[it[0]-1][it[1]-1] = it[2] }
        (0 until n).forEach{ this[it][it] = 0 }
    }

    for(i in 0 until n){
        for(j in 0 until n){
            for(k in 0 until n){
                answer[j][k] = answer[j][k].coerceAtMost(answer[j][i] + answer[i][k])
            }
        }
    }

    return answer
}

private fun main(){
    val arr = arrayOf(
        intArrayOf( 1, 2, 4 ), intArrayOf( 1, 4, 6 ), intArrayOf( 2, 1, 3 ),
        intArrayOf( 2, 3, 7 ), intArrayOf( 3, 1, 5 ), intArrayOf( 3, 4, 4 ),
        intArrayOf( 4, 3, 2 ))

    arrayOf(intArrayOf(0,4,8,6), intArrayOf(3,0,7,9), intArrayOf(5,9,0,4), intArrayOf(7,11,2,0)).forEach{row ->
        row.forEach { print("${it}\t") }
        println()
    }
    println()
    solution(4,7,arr).forEach{row ->
        row.forEach { print("${it}\t") }
        println()
    }
}