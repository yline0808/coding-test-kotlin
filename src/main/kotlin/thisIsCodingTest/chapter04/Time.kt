package thisIsCodingTest.chapter04

private fun solution(n:Int):Int{
    var answer = 0

    for(h in 0..n){
        for(m in 0..59){
            for(s in 0..59){
                if((h.toString() + m.toString() + s.toString()).contains("3")) answer++
            }
        }
    }

    return answer
}

private fun main(){
    println("11475\n${solution(5)}")
}
