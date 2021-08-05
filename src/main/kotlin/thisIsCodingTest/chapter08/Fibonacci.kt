package thisIsCodingTest.chapter08

private fun fibonacci1(n:Int):Long{
    val arr = LongArray(n + 1).apply {
        this[1] = 1
        this[2] = 1
    }

    for(i in 2..n){
        arr[i] = arr[i - 2] + arr[i - 1]
    }

    return arr[n]
}

private fun fibonacci2(n:Int):Long{
    if(n <= 2) return 1
    return fibonacci2(n - 2) + fibonacci2(n - 1)
}

private fun main(){
    println(1134903170)
    println(fibonacci1(45))
    println(fibonacci2(45))
}