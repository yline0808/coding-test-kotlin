package programmers.level2

/*
 * 제목 : 행렬의 곱샘
 * url : https://programmers.co.kr/learn/courses/30/lessons/12949
 * 유형 : 연습문제
 */

private fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>{
    var answer = Array(arr1.size){
        IntArray(arr2.size)
    }

    for(i in arr1.indices){
        for(j in arr2.indices){
            for(k in arr2[0].indices){
                answer[i][k] += arr1[i][j] * arr2[j][k]
            }
        }
    }

    return answer
}

private fun bestSolution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>{
    return Array(arr1.size){ i ->
        Array(arr2[0].size){ j ->
            var value = 0
            for(k in arr2.indices){
                value += arr1[i][k] * arr2[k][j]
            }
            value
        }.toIntArray()
    }
}

private fun main(){
    arrayOf(intArrayOf(22,22,11), intArrayOf(36,28,18), intArrayOf(29,20,14)).map { arr ->
        arr.map{print("${it}\t")}
        println()
    }
    println()
    solution(arrayOf(intArrayOf (2, 3, 2 ), intArrayOf (4, 2, 4 ), intArrayOf (3, 1, 4 )), arrayOf(intArrayOf( 5, 4, 3 ), intArrayOf( 2, 4, 1 ), intArrayOf( 3, 1, 1 ))).map { arr ->
        arr.map{print("${it}\t")}
        println()
    }
    println()
    bestSolution(arrayOf(intArrayOf (2, 3, 2 ), intArrayOf (4, 2, 4 ), intArrayOf (3, 1, 4 )), arrayOf(intArrayOf( 5, 4, 3 ), intArrayOf( 2, 4, 1 ), intArrayOf( 3, 1, 1 ))).map { arr ->
        arr.map{print("${it}\t")}
        println()
    }
    println()

    arrayOf(intArrayOf(15, 15), intArrayOf(15, 15), intArrayOf(15, 15)).map { arr ->
        arr.map { print("${it}\t") }
        println()
    }
    println()
    solution(arrayOf(intArrayOf( 1, 4 ), intArrayOf( 3, 2 ), intArrayOf( 4, 1 )), arrayOf(intArrayOf(3,3), intArrayOf(3,3))).map { arr ->
        arr.map { print("${it}\t") }
        println()
    }
    println()
    bestSolution(arrayOf(intArrayOf( 1, 4 ), intArrayOf( 3, 2 ), intArrayOf( 4, 1 )), arrayOf(intArrayOf(3,3), intArrayOf(3,3))).map { arr ->
        arr.map { print("${it}\t") }
        println()
    }
}