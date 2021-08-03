package thisIsCodingTest.chapter03

private fun solution(n:Int, k:Int):Int{
    var answer = 0
    var num = n

    while(true){
        var target = (num / k) * k
        answer += (num - target)
        num = target

        if( num < k ) break

        answer++
        num /= k
    }

    return answer + (num - 1)
}

private fun main(){
    println("2\n${solution(25, 5)}")
    println("6\n${solution(25, 3)}")
}