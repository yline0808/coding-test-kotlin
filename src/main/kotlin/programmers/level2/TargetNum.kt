package programmers.level2

/*
 * 제목 : 타겟 넘버
 * url : https://programmers.co.kr/learn/courses/30/lessons/43165
 * 유형 : 깊이/너비 우선 탐색(DFS/BFS)
 */

//private fun solution(numbers:IntArray, target:Int):Int{
//    return dfs(numbers, target, 0, 0)
//}
private fun solution(numbers:IntArray, target:Int) = dfs(numbers, target, 0, 0)
private fun dfs(numbers:IntArray, target:Int, index:Int, num:Int):Int{
    return if(index == numbers.size) if(target == num) 1 else 0
    else dfs(numbers, target, index + 1, num + numbers[index]) + dfs(numbers, target, index + 1, num - numbers[index])
}

private fun testSolution(numbers:IntArray, target:Int):Int{
    return numbers.fold(listOf(0)) { list, i ->
        list.run {
            map { it + i } + map { it - i }
        }
    }.count { it == target }
}

private fun main(){
    println("5\n${testSolution(intArrayOf(1,1,1,1,1), 3)}")
    println(solution(intArrayOf(1,1,1,1,1), 3))
}