package study.Chapter03Null

private class Person{
    lateinit var name:String
    init{
        name = "Yline"
    }

    fun process(){
        name.plus("0808")
        println("len = ${name.length}")
        println("first = ${name.substring(0,1)}")
    }
}

private fun main(){
    // nullable
    var num:Int? = null
    // ? => safe call, ?: => 엘빅스 익스프레션 뒤에 오는 숫자는 기본값
    var result = num?.plus(27) ?: 100

    var result2 = result.plus(3)

    println("${num}, ${result}, ${result2}")
    println("${Person().name}")
    println("${Person().name}")
}