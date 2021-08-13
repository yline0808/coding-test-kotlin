package thisIsCodingTest.chapter12

/*
 * 기둥은 -> 바닥 위 || 보의 한쪽 끝부분 위 || 다른 기둥 위
 * 보는 -> 한쪽 끝 부분이 기둥 위 || 양쪽 끝부분이 다른 보와 동시 연결
 *
 * x,y -> 좌표
 * a -> 0 : 기동, 1 : 보
 * b -> 0 : 삭제, 1 : 설치
 *
 * [x, y, a, b]
 * [x, y, 재로, 설치여부]
 */

private fun solution(buildFrame:Array<IntArray>):Array<IntArray>{
//    data class Node(val x:Int, val y:Int, val stuff:Int):Comparable<Node>{
//        override fun compareTo(other:Node):Int{
//            if(this.x == other.x )
//        }
//    }

    val answer = arrayOf(intArrayOf())

    return answer
}

private fun main(){
    val buildFrameList = arrayOf(
        arrayOf(
            intArrayOf(1,0,0,1),
            intArrayOf(1,1,1,1),
            intArrayOf(2,1,0,1),
            intArrayOf(2,2,1,1),
            intArrayOf(5,0,0,1),
            intArrayOf(5,1,0,1),
            intArrayOf(4,2,1,1),
            intArrayOf(3,2,1,1)
        ),
        arrayOf(
            intArrayOf(0,0,0,1),
            intArrayOf(2,0,0,1),
            intArrayOf(4,0,0,1),
            intArrayOf(0,1,1,1),
            intArrayOf(1,1,1,1),
            intArrayOf(2,1,1,1),
            intArrayOf(3,1,1,1),
            intArrayOf(2,0,0,0),
            intArrayOf(1,1,1,0),
            intArrayOf(2,2,0,1),
        )
    )
    val resultList = arrayOf(
        arrayOf(
            intArrayOf(1,0,0),
            intArrayOf(1,1,1),
            intArrayOf(2,1,0),
            intArrayOf(2,2,1),
            intArrayOf(3,2,1),
            intArrayOf(4,2,1),
            intArrayOf(5,0,0),
            intArrayOf(5,1,0)
        ),
        arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,1),
            intArrayOf(1,1,1),
            intArrayOf(2,1,1),
            intArrayOf(3,1,1),
            intArrayOf(4,0,0),
        )
    )

    for(i in 0..1){
        resultList[i].forEach { row ->
            row.forEach { print("${it}\t") }
            println()
        }
        println("-------------------")
        solution(buildFrameList[i]).forEach { row ->
            row.forEach { print("${it}\t") }
            println()
        }
        println()
    }
}