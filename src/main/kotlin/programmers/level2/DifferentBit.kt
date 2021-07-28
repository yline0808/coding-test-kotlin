package programmers.level2

/*
 * 문제 : 2개 이하로 다른 비트
 * url : https://programmers.co.kr/learn/courses/30/lessons/77885
 * 유형 : 월간 코드 챌린지 시즌2
 *
 * 7
 * map
 * 111
 * 1000 and 111 + 1
 *
 * let
 * 111 or 1000 and inv(100)
 * = 1111 and 1011
 * = 1011
 * = 11(10)
 *
 * -1 이진수 변환 과정(맨 앞 부호비트)
 * 0 001 => 10진수 2진수로
 * 1 001 => 부호 음수로
 * 1 110 => 비트 반전
 * 1 111 => 캐리값 1 더하기
 */

private fun solution(numbers:LongArray):LongArray{
    return numbers.map { n -> (n.inv() and n + 1).let { n or it and (it shr 1).inv() } }.toLongArray()
}

private fun main(){
    println("${3}\t${11}\t${7}")
    solution(longArrayOf(2, 7, 6)).map { print("${it}\t") }
}
