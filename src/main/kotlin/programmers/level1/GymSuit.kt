package programmers.level1

/*
 * 제목 : 체육복
 * url : https://programmers.co.kr/learn/courses/30/lessons/42862
 * 유형 : 탐욕볍
 */

fun solution(n:Int, lost:IntArray, reserve:IntArray):Int{
    var answer = 0
    val arr = IntArray(n+2){1}     //시작 1부터, 끝 1개 오류방지, {1}하면 전부 1로
    lost.forEach { arr[it]-- }
    reserve.forEach { arr[it]++ }

    for(i in 1 .. n){
        if(arr[i] == 0 && arr[i - 1] == 2)
            arr[i]++.also { arr[i-1]-- }
        else if(arr[i] == 0 && arr[i + 1] == 2)
            arr[i]++.also { arr[i + 1]-- }
    }

    for(i in 1 .. n)
        if(arr[i] > 0)
            answer++

    return answer
}

fun main(){
    println(5)
    println(solution(5, intArrayOf(2,4), intArrayOf(1,3,5)))
}
