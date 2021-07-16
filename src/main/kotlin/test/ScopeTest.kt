package test

/**
 * 스코프 함수 : apply, run, with, also, let
 * => 스코프 함수는 인스턴스의 속성이나 함수를 scope 내에서 깔끔하게 분리하여 사용할 수 있다는 점 때문에 코드의 가독성을
 *   향상시킨다는 장점이 있다.
 *
 * apply -> 인스턴스 생성한 후 변수에 담기 전 '초기화 과정'을 수행할 때 많이 쓰임
 * run -> apply처럼 참조연산자 없이 사용 가능하지만 일반 람다함수처럼 인스턴스 대신 마지막 구문의 결과값을 반환
 *      따라서 이미 인스턴스가 만들어진 후에 인스턴스의 함수나 속성을 scope 내에서 사용해야 할 때 유용
 * with -> run과 동일한 기능을 가지지만 단지 인스턴스를 참조연산자 대신 패러미터로 받는다는 차이 뿐
 *      a.run{...} a.with(a){...}  (정말 차이가 이거밖에 없음!!)
 *
 * apply / also -> 처리가 끝나면 인스턴스를 반환
 * run / let -> 처리가 끝나면 최종값을 반환
 *
 * also / let -> 마치 패러미터로 인스턴스를 넘긴거처럼 it을 통하여 인스턴스 사용가능
 *              이 두 함수는 왜 굳이 패러미터를 통해서 인스턴스를 사용하는 귀찮은 과정을 거치는지?
 *              = 같은 이름의 변수나 함수가 'scope 바깥'에 중복되어 있는 경우에 혼란을 방지하기 위해서
 */

fun main(){
    var name = "자바"
    var price = 5000

//  apply 는 참조연산자 없이 사용가능, 생성된 인스턴스를 반환하기 때문에 바로 a에 넣어줌
    var a = Book("코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
    }

//  run함수가 인스턴스 내의 price 속성보다 run이 속해있는 main 함수의 price 변수를 우선시하고 있기 때문에 5000이 출력
    a.run {
        println("상품명 : $name, 가격 : $price")
    }

//  위 run에서의 오류를 보완하기 위해 let을 사용 (apply역시 같은 경우가 있을경우 also로 바꾸어 사용하면 됨)
    a.let {
        println("상품명 : ${it.name}, 가격 : ${it.price}")
    }

    a = Book("코틀린", 10000).also {
        it.name = "[초특가]" + it.name
        it.discount()
    }

    a.let {
        println("상품명 : ${it.name}, 가격 : ${it.price}")
    }
}

class Book(var name: String, var price: Int){
    fun discount(){
        price -= 2000
    }
}