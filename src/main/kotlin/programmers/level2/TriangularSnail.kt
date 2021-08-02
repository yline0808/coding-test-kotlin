package programmers.level2

/*
 * 문제 : 삼각 달팽이
 * url : https://programmers.co.kr/learn/courses/30/lessons/68645
 * 유형 : 월간 코드 챌린지 시즌1
 */

private fun solution(n:Int):IntArray{
    val max = n * (n + 1) / 2
    val answer = IntArray(max)
    val arr = Array<IntArray>(n){ IntArray(it + 1) }

    var value = 1
    var top = 0
    var left = 0
    var bottom = n - 1
    var right = n - 1

    while(max >= value){
        for(i in top..bottom){
            if(max < value) break
            arr[i][left] = value++
        }
        if(max < value) break
        left++
        top++

        for(i in left..right){
            if(max < value) break
            arr[bottom][i] = value++
        }
        if(max < value) break
        right--
        bottom--

        var idx = right
        for(i in bottom downTo top){
            if(max < value) break
            arr[i][idx--] = value++
        }
        if(max < value) break
        top++
        right--
    }

    var idx = 0
    for(i in arr){
        for(j in i){
            answer[idx++] = j
        }
    }
//    for(i in 0 until n){
//        for(j in 0..i){
//            answer[idx++] = arr[i][j]
//        }
//    }

    return answer
}

private fun main(){
    intArrayOf(1,2,9,3,10,8,4,5,6,7).forEach { print("${it}\t") }
    println()
    solution(4).forEach { print("${it}\t") }
    println("\n")

    intArrayOf(1,2,12,3,13,11,4,14,15,10,5,6,7,8,9).forEach { print("${it}\t") }
    println()
    solution(5).forEach { print("${it}\t") }
    println("\n")

    intArrayOf(1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11).forEach { print("${it}\t") }
    println()
    solution(6).forEach { print("${it}\t") }
}