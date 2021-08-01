package programmers.level2

import java.math.BigInteger

/*
 * 문제 : 멀쩡한 사각형
 * url : https://programmers.co.kr/learn/courses/30/lessons/62048
 * 유형 : Summer/Winter Coding(2018)
 *
 * 참고 : https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
 */

private fun solution(w:Int, h:Int)
    = w * h - (w + h - BigInteger.valueOf(w.toLong()).gcd(BigInteger.valueOf(h.toLong())).toLong())

private fun main(){
    println("80\n${solution(8, 12)}")
}