package study.Chapter03Null

private fun main(){
    // nullable
    var num:Int? = null
    // ? => safe call, ?: => 엘빅스 익스프레션 뒤에 오는 숫자는 기본값
    var result = num?.plus(27) ?: 100

    var result2 = result.plus(3)
}