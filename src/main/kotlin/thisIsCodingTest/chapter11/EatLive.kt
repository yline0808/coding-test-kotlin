package thisIsCodingTest.chapter11

private fun solution(foodTimes:IntArray, k:Int):Int{
    var s = 0
    val arr:MutableList<Int> = foodTimes.toMutableList()

    while(s <= k){
        if(arr[s % arr.size] == 0) arr.removeAt(s % arr.size)
        arr[s % arr.size]--
        s++
    }

    return s % foodTimes.size + 1
}

private fun bookSolution(foodTimes:IntArray, k:Int):Int{
    data class Food(val time:Int, val index:Int):Comparable<Food>{
        override fun compareTo(other:Food):Int{
            return this.time - other.time
        }
    }

    var answer = 0

    return answer
}

private fun main(){
    println("1\n${solution(intArrayOf(3,1,2), 5)}")
    println("1\n${bookSolution(intArrayOf(3,1,2), 5)}")
    println("4\n${solution(intArrayOf(3,4,1,2,5), 7)}")
    println("4\n${bookSolution(intArrayOf(3,4,1,2,5), 7)}")
}