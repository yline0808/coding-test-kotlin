package thisIsCodingTest.chapter12

private fun checkLock(arr:Array<IntArray>):Boolean{
    val arrSize = arr.size / 3
    for(i in arrSize until arrSize * 2 ){
        for(j in arrSize until arrSize * 2){
            if(arr[i][j] != 1) return false
        }
    }

    return true
}

// 시계방향 회전
private fun rotation(key:Array<IntArray>){
    var arr = Array<IntArray>(key.size){ IntArray(key.size) }
    for(i in key.indices){
        for(j in key.indices){
            arr[j][key.size - 1 - i] = key[i][j]
        }
    }
    arr.forEachIndexed { idx, item -> key[idx] = item }
}

private fun solution(key:Array<IntArray>, lock:Array<IntArray>):Boolean{
    val arr = Array<IntArray>(lock.size * 3){ IntArray(lock.size * 3) }

    for(i in lock.indices){
        for(j in lock.indices){
            arr[lock.size + i][lock.size + j] = lock[i][j]
        }
    }

    for(r in 0 until 4){
        rotation(key)

        for(x in 1 until lock.size * 2){
            for(y in 1 until lock.size * 2){
                for(i in key.indices){
                    for(j in key.indices){
                        arr[x + i][y + j] += key[i][j]
                    }
                }

                if(checkLock(arr)) return true

                for(i in key.indices){
                    for(j in key.indices){
                        arr[x + i][y + j] -= key[i][j]
                    }
                }
            }
        }
    }

    return false
}

private fun main(){
    val key = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(1,0,0),
        intArrayOf(0,1,1)
    )
    val lock = arrayOf(
        intArrayOf(1,1,1),
        intArrayOf(1,1,0),
        intArrayOf(1,0,1)
    )

    println("true\n${solution(key, lock)}")
}