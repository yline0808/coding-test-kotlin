package thisIsCodingTest.chapter10

private val parent = IntArray(7){it}

// 경로압축 기법
//private fun findParent2(x:Int):Int{
//    if(parent[x] != x) parent[x] = findParent(parent[x])
//    return parent[x]
//}

private fun findParent(x:Int):Int{
    return if(x == parent[x]) x else findParent(parent[x])
}

private fun unionParent(a:Int, b:Int){
    val a = findParent(a)
    val b = findParent(b)
    if(a < b) parent[b] = a else parent[a] = b
}

private fun solution(n:Int, v:Int, arr:Array<IntArray>){
    print("각 원소가 속한 집합 : 1\t1\t1\t1\t5\t5\n각 원소가 속한 집합 : ")
    arr.forEach { unionParent(it[0], it[1]) }
    (1..n).forEach{ print("${findParent(it)}\t") }

    print("\n부모 테이블 : 1\t1\t2\t1\t5\t5\n부모 테이블 : ")
    parent.sliceArray(1..n).forEach { print("${it}\t") }
}

private fun main(){
    val arr = arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(5,6))
    solution(6,4,arr)
}