package study.Chapter03Class

// 1. 상속
private open class Parent{
    var hello = "hello"
    fun sayHello(){
        println(hello)
    }
}

private class Child: Parent(){
    fun myHello(){
        hello = "Hello!"
        sayHello()
    }
}

// 2. 상속
private open class BaseClass{
    open fun opened(){

    }
    fun notOpened(){

    }
}

private class ChildClass:BaseClass(){
    override fun opened() {

    }
//    부모가 open 키워드가 없어서 불가능
//    override fun notOpened(){
//
//    }
}

// 3. 오버로딩
private open class BaseClass2{
    open var opened: String = "I am"
}

private class ChildClass2: BaseClass2(){
    override var opened:String = "You are"
}

// 4. 익스텐션 (기존 클래스에 추가로 설계하는것)
private fun testStringExtension(){
    var original = "Hello"
    var added = " Guys~"
    println(original.plus(added))
}

private fun String.plus(word: String): String = this + word

private fun main(){
    // 1. 상속
    val child = Child()
//    부모의 hello 변수가 자식클래스에서 수정됨
    child.myHello()

    // 3. 오버로딩
    val base2 = BaseClass2()
    val child2 = ChildClass2()

    println(child2.opened)
    println(base2.opened)

    // 4. 익스텐션
    testStringExtension()
}