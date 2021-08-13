package thisIsCodingTest.review

import java.util.Queue
import java.util.LinkedList

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

private data class Node(val direction:Int, val time:Int)

private data class Position(val x:Int, val y:Int)

private fun turnSnake(d:Int, c:Char) = if(c == 'L') (d + 3) % 4 else (d + 1) % 4

private fun solution(n:Int, k:Int, appleLoc:Array<IntArray>, l:Int, xld:Array<Pair<Int, Char>>):Int{
    var time = 0
    var idx = 0
    var direction = 0
    var x = 1
    var y = 1
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)
    val map = Array<IntArray>(n + 1){ IntArray(n + 1) }.apply {
        appleLoc.forEach{ this[it[0]][it[1]] = 1 }
        this[y][x] = 2
    }
    val q:Queue<Position> = LinkedList<Position>().apply{ offer(Position(x, y)) }
    val info = Array<Node>(l){
        direction = turnSnake( direction, xld[it].second )
        Node(direction, xld[it].first)
    }

    direction = 0

    while(true){
        val nx = x + dx[direction]
        val ny = y + dy[direction]

        if(nx in 1..n && ny in 1..n && map[ny][nx] != 2){
            if(map[ny][nx] == 0){
                map[ny][nx] = 2
                q.offer(Position(nx, ny))
                val pos = q.poll()
                map[pos.y][pos.x] = 0
            }
            if(map[ny][nx] == 1){
                map[ny][nx] = 2
                q.offer(Position(nx, ny))
            }
        }else{
            time++
            break
        }
        x = nx
        y = ny
        time++
        if(idx < l && info[idx].time == time){
            direction = info[idx++].direction
        }
    }

    return time
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
        println("${resultList[i]}\n${
            solution(nList[i],
                kList[i],
                appleLocList[i],
                lList[i],
                xldList[i])
        }\n")
    }
}