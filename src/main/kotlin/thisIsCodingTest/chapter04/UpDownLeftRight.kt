package thisIsCodingTest.chapter04

private fun solution(n:Int, arr:Array<String>):IntArray{
    val answer = IntArray(2){1}

    for(i in arr){
        if(i == "U" && (answer[0] > 1)) {
            answer[0]--
        }else if(i == "D" && answer[0] < n){
            answer[0]++
        }else if(i == "L" && answer[1] > 1){
            answer[1]--
        }else if(i == "R" && answer[1] < n){
            answer[1]++
        }else{
            continue
        }
    }

    return answer
}

private fun bookSolution(n:Int, arr:Array<String>):IntArray{
    var answer = IntArray(2){1}
    val next = IntArray(2){1}
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)
    val moveType = arrayOf("U", "D", "L", "R")

    for(i in arr){
        for(j in moveType.indices){
            if(moveType[j] == i){
                next[0] = answer[0] + dy[j]
                next[1] = answer[1] + dx[j]
            }
        }
        if(next[0] > 5 || next[0] < 1 || next[1] > 5 || next[1] < 1) continue

        answer = next.copyOf()
    }

    return answer
}

private fun main(){
    println("3\t4")
    solution(5, arrayOf("R","R","R","U","D","D")).forEach{ print("${it}\t") }
    println()
    bookSolution(5, arrayOf("R","R","R","U","D","D")).forEach { print("${it}\t") }
}