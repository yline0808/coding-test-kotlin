package thisIsCodingTest.chapter06

private fun solution(arr:IntArray):IntArray{
    for(i in arr.indices){
        var minIdx = i
        for(j in i + 1 until arr.size){
            if(arr[j] < arr[minIdx]){
                minIdx = j
            }
        }
        arr[i] = arr[minIdx].also { arr[minIdx] = arr[i] }
    }

    return arr
}

private fun main(){
    solution(intArrayOf(7,5,9,0,3,1,6,2,4,8)).forEach { print("${it}\t") }
}