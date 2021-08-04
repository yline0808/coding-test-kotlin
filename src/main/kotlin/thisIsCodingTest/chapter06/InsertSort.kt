package thisIsCodingTest.chapter06

private fun solution(arr:IntArray):IntArray{
    for(i in 1 until arr.size){
        for(j in i downTo 1){
            if(arr[j] < arr[j - 1]) arr[j] = arr[j - 1].also{ arr[j - 1] = arr[j] }
            else break
        }
    }

    return arr
}

private fun main(){
    solution(intArrayOf(7,5,9,0,3,1,6,2,4,8)).forEach{print("${it}\t")}
}