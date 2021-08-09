package thisIsCodingTest.chapter10

/*
 * 서로소 집합을 활용한 사이클 판별
 *
 * 1. 각 간선을 확인하며 두 노드의 루트 노드를 확인한다.
 *    - 루트 노드가 서로 다르면 두 노드에 대하여 union 연산을 수행한다.
 *    - 루트 노드가 서로 같다면 사이클이 발생한 것이다.
 * 2. 그래프에 포함되어 있는 모든 간선에 대하여 1번 과정을 반복한다.
 */

private val parent = IntArray(4){it}

private fun findParent(x:Int):Int{
    if(parent[x] != x) parent[x] = findParent(parent[x])
    return parent[x]
}

private fun unionParent(a:Int, b:Int){
    val ap = findParent(a)
    val bp = findParent(b)
    if(ap < bp) parent[bp] = ap else parent[ap] = bp
}

private fun solution(n:Int, v:Int, arr:Array<IntArray>):String{
    var cycle = false

    for(item in arr){
        if(findParent(item[0]) == findParent(item[1])){
            cycle = true
            break
        }else{
            unionParent(item[0], item[1])
        }
    }

    return "싸이클이 발생${if(cycle) "했습" else "하지 않았습"}니다."
}

private fun main(){
    val arr = arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,3))
    println("싸이클이 발생했습니다.\n${solution(3,3, arr)}")
}