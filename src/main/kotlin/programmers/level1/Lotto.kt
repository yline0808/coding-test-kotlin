package programmers.level1

/*
 * 문제 : 로또의 최고 순위와 최저 순위
 * url : https://programmers.co.kr/learn/courses/30/lessons/77484
 * 유형 : 2021 Dev-Matching: 웹 백엔드 개발자 (상반기)
 */

private fun solution(lottos:IntArray, winNums: IntArray):IntArray{
    var zero = 0
    var match = 0

    for(myNum in lottos){
        if(myNum == 0){
            zero++
        }else{
            for(winNum in winNums){
                if(myNum == winNum){
                    match++
                    break
                }
            }
        }
    }
    val max = zero + match
    val min = match
    return intArrayOf(6.coerceAtMost(7 - max), 6.coerceAtMost(7 - min))
}

private fun bestSolution(lottos: IntArray, winNums: IntArray): IntArray{
    return intArrayOf(
        (lottos.size + 1) - lottos.filter { winNums.contains(it) || it == 0 }.size,
        (lottos.size + 1) - lottos.filter(winNums::contains).size
    ).map { if (it > 6) it - 1 else it }.toIntArray()
}

private fun main(){
    intArrayOf(3,5).map { print("${it}\t") }
    println()
    solution(intArrayOf(44,1,0,0,31,25), intArrayOf(31,10,45,1,6,19)).map { print("${it}\t") }
    println()
    bestSolution(intArrayOf(44,1,0,0,31,25), intArrayOf(31,10,45,1,6,19)).map { print("${it}\t") }
}