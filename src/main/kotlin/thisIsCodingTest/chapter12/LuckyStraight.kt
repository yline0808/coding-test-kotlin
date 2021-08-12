package thisIsCodingTest.chapter12

private fun solution(n:Int):String{
    var str = n.toString()
    var num1 = 0
    var num2 = 0


    for(i in str.indices){
        if(i < str.length / 2){
            num1 += str[i].toString().toInt()
        }else{
            num2 += str[i].toString().toInt()
        }
    }

    return if(num1 == num2) "LUCKY" else "READY"
}

private fun main(){
    println("LUCKY\n${solution(123402)}")
    println("READY\n${solution(7755)}")
}