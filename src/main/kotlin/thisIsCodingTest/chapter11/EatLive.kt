package thisIsCodingTest.chapter11

/*
 * 참고 : https://www.youtube.com/watch?v=4MWxAt4fx5I
 * 타입 Int가 아니라 Long으로 해야 효율성 2번 통과됨
 */

private fun solution(foodTimes:IntArray, kk:Int):Int{
    data class Food(val time:Int, val idx:Int):Comparable<Food>{
        override fun compareTo(other:Food):Int{
            return this.time.compareTo(other.time)
        }
    }

    val foods = mutableListOf<Food>().apply {
        foodTimes.forEachIndexed{ idx, item -> add(Food(item, idx + 1)) }
        sort()
    }
    var n = foodTimes.size
    var pretime = 0
    var k = kk.toLong()
    for((i, f) in foods.withIndex()){
        val diff:Long = (f.time - pretime).toLong()
        if(diff != 0L){
            val spend:Long = diff * n
            if(spend <= k){
                k -= spend
                pretime = f.time
            }else{
                k %= n
                foods.subList(i, foodTimes.size).sortBy { food -> food.idx }
                return foods[i + k.toInt()].idx
            }
        }
        n--
    }

    return -1
}

private fun main(){
    println("1\n${solution(intArrayOf(3,1,2), 5)}")
    println("4\n${solution(intArrayOf(3,4,1,2,5), 7)}")

    println("\n==========\n23451245125255-1-1")
    var start = System.currentTimeMillis()
    for(i in 1..13){
        print("${solution(intArrayOf(3,4,1,2,5), i)}")
    }
    var end = System.currentTimeMillis()
    println("\n====${end - start}=====")
}