package thisIsCodingTest.chapter11

private fun solution(s:String):Int{
    var answer1 = if(s[s.length - 1] == '0') 1 else 0
    var answer2 = if(answer1 == 1) 0 else 1

    for(i in 1 until s.length){
        if(s[i-1] == '0' && s[i-1] != s[i]){
            answer1++
        }else if(s[i-1] == '1' && s[i-1] != s[i]){
            answer2++
        }
        else{
            continue
        }
    }

    return answer1.coerceAtMost(answer2)
}

private fun main(){
    println("1\n${solution("0001100")}")
    println("3\n${solution("1010101")}")
}