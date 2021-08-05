package thisIsCodingTest.chapter07

private fun binarySearch(arr:IntArray, target:Int):Boolean{
    var start = 0
    var end = arr.size - 1

    while(start <= end){
        val mid = (start+end)/2
        when{
            arr[mid] == target -> return true
            arr[mid] > target -> end = mid - 1
            else -> start = mid + 1
        }
    }

    return false
}

private fun solution(n:Int, arr:IntArray, m:Int, items:IntArray):Array<String>{
    val answer = Array<String>(m){""}

    arr.sort()

    for(i in items.indices){
        answer[i] = if(binarySearch(arr,items[i])) "yes" else "no"
    }

    return answer
}

private fun main(){
    println("no\tyes\tyes")
    solution(5, intArrayOf(8,3,7,9,2), 3, intArrayOf(5,7,9)).forEach { print("${it}\t") }
}