package programmers.level2

/*
 * 문제 : N개의 최소공배수
 * url : https://programmers.co.kr/learn/courses/30/lessons/12953
 * 유형 : 연습문제
 *
 * 참고 : 보통 공약수 관련 문제는 "유클리드 호제법" 사용
 * 최대공배수 = 두 수의 곱 / 최소공약수
 */

private fun gcd(a: Int, b: Int): Int{
    return if( a < b){
        if(a == 0) b else gcd(a, b % a)
    }else{
        if(b == 0) a else gcd(b, a % b)
    }
}

private fun lcm(a: Int, b: Int): Int{
    return a * b / gcd(a, b)
}

private fun solution(arr:IntArray):Int{
    var answer = arr[0]

    arr.map{ answer = lcm(answer, it) }

    return answer
}

private fun main(){
    println(168)
    println(solution(intArrayOf(2,6,8,14)))
}