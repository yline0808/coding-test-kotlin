package programmers.level1

/*
 * 문제 : K번째수
 * url : https://programmers.co.kr/learn/courses/30/lessons/42748
 * 유형 : 정렬
 */

private fun solution(array: IntArray, commands: Array<IntArray>): IntArray{
    val answer = IntArray(commands.size)

    for (i in commands.indices){
        val tmp = array.copyOfRange(commands[i][0] - 1, commands[i][1])
        tmp.sort()
        answer[i] = tmp[commands[i][2] - 1]
    }

    return answer
}

private fun bestSolution(array:IntArray, commands: Array<IntArray>):IntArray{
    return commands.map { command ->
        array.copyOfRange(command[0] - 1, command[1]).sorted()[command[2] - 1]
    }.toIntArray()
}

private fun main(){
    intArrayOf(5,6,3).map { print("${it}\t") }
    println()
    solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).map { print("${it}\t") }
    println()
    bestSolution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).map { print("${it}\t") }
}