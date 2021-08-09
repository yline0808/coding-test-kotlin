package thisIsCodingTest.chapter10

/*
 * 팀 합치기 0
 * 같은 팀 여부 확인 1
 */

private fun findParent(x:Int, team:IntArray):Int{
    if(x != team[x]) team[x] = findParent(team[x], team)
    return team[x]
}

private fun unionParent(a:Int, b:Int, team:IntArray){
    val ap = findParent(a, team)
    val bp = findParent(b, team)
    if(ap < bp) team[bp] = ap else team[ap] = bp
}

private fun solution(n:Int, m:Int, arr:Array<IntArray>):Array<String>{
    val answer = mutableListOf<String>()
    val team = IntArray(n + 1){it}

    for(i in arr){
        if(i[0] == 0){
            unionParent(i[1], i[2], team)
        }else{
            answer.add( if(findParent(i[1], team) == findParent(i[2], team)) "YES" else "NO" )
        }
    }

    return answer.toTypedArray()
}

private fun main(){
    val arr = arrayOf(
        intArrayOf(0,1,3), intArrayOf(1,1,7), intArrayOf(0,7,6), intArrayOf(1,7,1),
        intArrayOf(0,3,7), intArrayOf(0,4,2), intArrayOf(0,1,1), intArrayOf(1,1,1))
    println("NO\tNO\tYES")
    solution(7,8,arr).forEach { print("${it}\t") }
}