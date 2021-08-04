package thisIsCodingTest.chapter06

private fun solution(n:Int, arr:Array<Pair<String, Int>>):Array<String>{
    return arr.sortedBy { it.second }.map { it.first }.toTypedArray()
}

private fun main(){
    println("이순신\t홍길동")
    solution(2, arrayOf("홍길동" to 95, "이순신" to 77)).forEach{print("${it}\t")}
}