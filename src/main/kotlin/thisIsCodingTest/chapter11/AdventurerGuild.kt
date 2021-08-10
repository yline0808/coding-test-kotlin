package thisIsCodingTest.chapter11

private fun solution(n:Int, arr:IntArray):Int{
    var answer = 0
    var count = 0

    arr.forEach {
        count++
        if(count >= it){
            answer++
            count = 0
        }
    }

    return answer
}

private fun main(){
    val arr1 = intArrayOf(2,3,1,2,2)
    val arr2 = intArrayOf(1,2,3,4,5,6,7,8,9)
    println("2\n${solution(5, arr1)}")
    println("1\n${solution(5, arr2)}")
}