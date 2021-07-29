package programmers.level2

/*
 * 문제 : 소수 찾기
 * url : https://programmers.co.kr/learn/courses/30/lessons/42839
 * 유형 : 완전탑색
 *
 * 코테에서는 math.sqrt로 써야함
 */

private fun isPrimeNumber(num:Int):Boolean{
    if(num <= 1) return false
    return !(2..Math.sqrt(num.toDouble()).toInt()).any { num % it == 0 }
}

private fun premutation(prefix:String, str:String, set:HashSet<Int>){
    if(prefix != "")
        set.add(prefix.toInt())
    for(i in str.indices)
        premutation(prefix + str[i], str.substring(0, i) + str.substring(i + 1, str.length), set)
}

private fun solution(numbers:String):Int{
    var answer = 0
    val set = HashSet<Int>()

    premutation("", numbers, set)

    while(set.iterator().hasNext()){
        val a = set.iterator().next()
        set.remove(a)
        if(isPrimeNumber(a)) answer++
    }

    return answer
}

private fun main(){
    println("3\n${solution("17")}\n")
    println("2\n${solution("011")}\n")
}