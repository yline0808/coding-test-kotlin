package test

private fun whenTest(){
    val a = 2
    val b = intArrayOf(1,2,3,4,5)
    val c = intArrayOf(1,3,4,5,6)

    println(a in b)
    println(a in c)

    when {
        a == 2 -> println("2")
        a % 2 == 0 -> println("짝수")
        else -> println("else")
    }
}

private fun forEachTest(){
    (0..9).forEach { print(it) }
}

private fun mapTest(){
    (0..9).map { i -> print(i) }
    println()
    (0..9).map { print(it) }
}

private fun coerceAtMostTest(){
    val a = 10
    val b = 5
    println(a.coerceAtMost(b))
    println(b.coerceAtMost(a))
    println(a.coerceAtLeast(b))
    println(b.coerceAtLeast(a))
}

private fun reflection(){
    fun isOdd(num : Int):Boolean = num % 2 != 0

    val numbers = intArrayOf(1,2,3,4,5,6)
    numbers.filter(::isOdd).map { print(it) }
    println()
    val a = intArrayOf(1,2,3,4,3,3)
    val b = intArrayOf(1,3,3)

    //여기가 핵심
    a.filter(b::contains).map(::print)
    println()
    a.filter { b.contains(it) }.map(::print)
    println()

    b.filter(a::contains).map(::print)
    println()
    a.map(3::equals).map(::print)
    println()
    b.map(3::equals).map(::print)
}

private fun main(){
    println("---test when---")
    whenTest()
    println("======")

    println("---test foreach---")
    forEachTest()
    println("======")

    println("---test map---")
    mapTest()
    println("======")

    println("---test coerceAtMost---")
    coerceAtMostTest()
    println("======")

    println("---test :: reflection---")
    reflection()
    println("======")
}