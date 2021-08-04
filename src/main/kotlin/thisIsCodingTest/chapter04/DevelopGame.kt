package thisIsCodingTest.chapter04

/*
 * 0 북
 * 1 동
 * 2 남
 * 3 서
 */

private fun turnLeft(d:Int):Int{
    return if(d <= 0) 3 else d - 1
}

private fun solution(n:Int, m:Int, user:IntArray, arr:Array<IntArray>):Int{
    val dx = intArrayOf(0,1,0,-1)
    val dy = intArrayOf(-1,0,1,0)

    var answer = 1
    var x = user[0]
    var y = user[1]
    var direction = user[2]
    var turnCnt = 0
    arr[y][x] = 2

    while(true){
        direction = turnLeft(direction)
        var nx = x + dx[direction]
        var ny = y + dy[direction]
        if(arr[ny][nx] == 0){
            x = nx
            y = ny
            arr[y][x] = 2
            turnCnt = 0
            answer++
            continue
        }else turnCnt++

        if(turnCnt == 4){
            nx = x - dx[direction]
            ny = y - dy[direction]

            if(arr[ny][nx] == 0){
                x = nx
                y = ny
            }else break

            turnCnt = 0
        }
    }

    return answer
}

private fun main(){
    println("3\n${solution(4,4, intArrayOf(1,1,0), arrayOf(
        intArrayOf(1,1,1,1), intArrayOf(1,0,0,1), intArrayOf(1,1,0,1), intArrayOf(1,1,1,1))
    )}")
}