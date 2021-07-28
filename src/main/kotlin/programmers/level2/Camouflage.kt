package programmers.level2

/*
 * 문제 : 위장
 * url : https://programmers.co.kr/learn/courses/30/lessons/42578
 * 유형 : 해시
 */

private fun solution(clothes: Array<Array<String>>):Int{
    val hm = HashMap<String, Int>()

    for(cloth in clothes){
        hm[cloth[1]] = hm.getOrDefault(cloth[1], 1).plus(1)
    }

    return hm.values.reduce { result, item -> result * item } - 1
}

private fun bestSolution(clothes:Array<Array<String>>):Int{
    return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) }  - 1
}

private fun main(){
    println(5)
    println(solution(arrayOf(arrayOf( "yellowhat", "headgear" ), arrayOf( "bluesunglasses", "eyewear" ), arrayOf( "green_turban", "headgear" ))))
    println(bestSolution(arrayOf(arrayOf( "yellowhat", "headgear" ), arrayOf( "bluesunglasses", "eyewear" ), arrayOf( "green_turban", "headgear" ))))
    println()

    println(3)
    println(solution(arrayOf(arrayOf( "crowmask", "face" ), arrayOf( "bluesunglasses", "face" ), arrayOf( "smoky_makeup", "face" ))))
    println(bestSolution(arrayOf(arrayOf( "crowmask", "face" ), arrayOf( "bluesunglasses", "face" ), arrayOf( "smoky_makeup", "face" ))))
}