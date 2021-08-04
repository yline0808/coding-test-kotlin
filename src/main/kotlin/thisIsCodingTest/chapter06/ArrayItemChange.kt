package thisIsCodingTest.chapter06

private fun solution(n:Int, k:Int, arr1:IntArray, arr2:IntArray):Int{
    arr1.sort()
    arr2.sortDescending()

    for(i in 0 until k){
        arr1[i] = arr2[i].also { arr2[i] = arr1[i] }
    }

    return arr1.sum()
}

private fun main(){
    println("26\n${solution(5,3, intArrayOf(1,2,5,4,3), intArrayOf(5,5,6,6,5))}")
}