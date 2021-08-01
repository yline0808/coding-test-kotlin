package programmers.level2

/*
 * 문제 : 쿼드 압축 후 개수 세기
 * url : https://programmers.co.kr/learn/courses/30/lessons/68936
 * 유형 : 월간 코드 챌린지 시즌 1
 */

private lateinit var map:Array<IntArray>
private fun solution(arr: Array<IntArray>):IntArray{
    map = arr
    return IntArray(2).apply { dfs(arr.size, 0, 0, this) }
}

private fun dfs(n:Int, x:Int, y:Int, answer:IntArray){
    if(n == 1){
        answer[map[x][y]]++
        return
    }
    if(isSame(n, x, y, answer)) return

    dfs(n/2, x, y, answer)
    dfs(n/2, x + n/2, y, answer)
    dfs(n/2, x, y + n/2, answer)
    dfs(n/2, x + n/2, y + n/2, answer)
}

private fun isSame(n:Int, x:Int, y:Int, answer:IntArray):Boolean{
    val first = map[x][y]

    for(i in x until x + n){
        for(j in y until y + n){
            if(first != map[i][j]) return false
        }
    }
    answer[first]++
    return true
}

private fun main(){
    println("4\t9")
    solution(arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))).map { print("${it}\t") }

    println("\n\n10\t15")
    solution(arrayOf(
        intArrayOf(1,1,1,1,1,1,1,1), intArrayOf(0,1,1,1,1,1,1,1),
        intArrayOf(0,0,0,0,1,1,1,1), intArrayOf(0,1,0,0,1,1,1,1),
        intArrayOf(0,0,0,0,0,0,1,1), intArrayOf(0,0,0,0,0,0,0,1),
        intArrayOf(0,0,0,0,1,0,0,1), intArrayOf(0,0,0,0,1,1,1,1))).map { print("${it}\t") }
}