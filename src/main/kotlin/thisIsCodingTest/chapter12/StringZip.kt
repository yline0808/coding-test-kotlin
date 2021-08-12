package thisIsCodingTest.chapter12

private fun solution(s:String):Int{
    var answer = s.length

    for(i in 1..s.length / 2){
        var zipStr = s.substring(0,i)
        var zipLevel = 1
        var result = ""

        for(j in i..s.length step i){
            if(zipStr == s.substring(j, if(j + i >= s.length) s.length else j + i)){
                zipLevel++
            }else{
                result += (if(zipLevel == 1) "" else zipLevel.toString()) + zipStr
                zipStr = s.substring(j, if(j + i >= s.length) s.length else j + i)
                zipLevel = 1
            }
        }
        result += zipStr
        answer = answer.coerceAtMost(result.length)
    }
    return answer
}

private fun main(){
    val sList = arrayOf<String>(
        "aabbaccc",
        "ababcdcdababcdcd",
        "abcabcdede",
        "abcabcabcabcdededededede",
        "xababcdcdababcdcd"
    )
    val resultList = intArrayOf(7,9,8,14,17)

    for(i in sList.indices){
        println("${resultList[i]}\n${solution(sList[i])}\n")
    }
}