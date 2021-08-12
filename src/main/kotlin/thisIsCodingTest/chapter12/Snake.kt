package thisIsCodingTest.chapter12

/*
 * 보드크기 : N
 * 사과개수 : K
 * 2개 행, 열
 * 방향 변수 : L
 * 초 : X, 왼쪽 : L, 오른쪽 : D
 *
 * ➡️ ⬇️ ⬅️ ⬆️
 * 0  1  2  3
 */

private fun turnSnake(direction:Int, c:Char) = if(c == 'L') (direction + 3) % 4 else (direction + 1) % 4

private fun solution(n:Int, k:Int, appleLoc:Array<IntArray>, l:Int, xld:Array<Pair<Int, Char>>):Int{
//  뱀이 있는 자리는 2, 사과는 1로 표시해서 한번 시도중...
    var answer = 0
    var snakeSize = 1
    var direction = 0
    val map = Array<IntArray>(n){IntArray(n)}.apply{
        appleLoc.forEach { this[it[0] - 1][it[1] - 1] = 1 }
    }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

//    for(move in xld){
//        for(i in move.first)
//    }

    println(-1 % 4)

    return answer
}

private fun main(){
    val nList = intArrayOf(6,10,10)
    val kList = intArrayOf(3,4,5)
    val appleLocList = arrayOf(
        arrayOf(intArrayOf(3,4), intArrayOf(2,5), intArrayOf(5,3)),
        arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(1,4), intArrayOf(1,5)),
        arrayOf(intArrayOf(1,5), intArrayOf(1,3), intArrayOf(1,2), intArrayOf(1,6), intArrayOf(1,7))
    )
    val lList = intArrayOf(3,4,4)
    val xldList = arrayOf(
        arrayOf(3 to 'D', 15 to 'L', 17 to 'D'),
        arrayOf(8 to 'D', 10 to 'D', 11 to 'D', 13 to 'L'),
        arrayOf(8 to 'D', 10 to 'D', 11 to 'D', 13 to 'L')
    )
    val resultList = intArrayOf(9,21,13)

    for(i in 0..2){
        println("${resultList[i]}\n${solution(nList[i],kList[i],appleLocList[i],lList[i],xldList[i])}\n")
    }
}