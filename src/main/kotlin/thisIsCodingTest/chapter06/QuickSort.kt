package thisIsCodingTest.chapter06

private fun quickSort(arr:IntArray, start:Int, end:Int){
    if(start >= end) return
    var pivot = start
    var left = start + 1
    var right = end

    while(left <= right){
        while(left <= end && arr[left] <= arr[pivot]) left++
        while(right > start && arr[right] >= arr[pivot]) right--
        if(left > right) arr[pivot] = arr[right].also { arr[right] = arr[pivot] }
        else arr[left] = arr[right].also { arr[right] = arr[left] }
    }
    quickSort(arr, start, right - 1)
    quickSort(arr, right + 1, end)
}

private fun main(){
    val arr = intArrayOf(7,5,9,0,3,1,6,2,4,8)
    quickSort(arr, 0, arr.size - 1)
    for(i in arr) print("${i}\t")
}