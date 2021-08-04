package thisIsCodingTest.chapter06

private fun solution(n:Int, arr:IntArray) = arr.sortedDescending().toIntArray()

private fun main(){
    println("27\t15\t12")
    solution(3, intArrayOf(15,27,12)).forEach{print("${it}\t")}
}