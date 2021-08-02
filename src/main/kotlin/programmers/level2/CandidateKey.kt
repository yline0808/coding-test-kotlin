package programmers.level2

/*
 * 문제 : 후보키
 * url : https://programmers.co.kr/learn/courses/30/lessons/42890
 * 유형 : 2019 KAKAO BLIND RECRUITMENT
 *
 * 참고 : https://velog.io/@hyeon930/프로그래머스-후보키-Java
 * 이해가 잘 안감...
 *
 * 만약 데이터 개수가 많을 경우를 대비해서 비트마스킹을 이용하여 풀어야함
 */

private fun isUnique(set:Int, rowLen:Int, colLen:Int, relation:Array<Array<String>>):Boolean{
    val map = HashMap<String, String>()
//    자릿수 구하기
    for(row in 0 until rowLen){
        var dataByKeySet = ""
        for(th in 0 until colLen){
            if((set and (1 shl th)) != 0){
                dataByKeySet += relation[row][th]
            }
        }
//        키를 가지고 있으면 유일하지 않음
        if(map.containsKey(dataByKeySet)) return false
        else map[dataByKeySet] = dataByKeySet
    }
    return true
}

private fun solution(relation:Array<Array<String>>):Int{
    val candidateKey = mutableListOf<Int>()
    var rowLen = relation.size
    var colLen = relation[0].size

//    모든 조합 구하기
    for(set in 1..(1 shl colLen)){
//        포함관계 구하기
        if(candidateKey.any { (set and it) == it }) continue
//        if(candidateKey.any { (set and it) == it }) continue
        if(isUnique(set, rowLen, colLen, relation)) candidateKey.add(set)
    }
    return candidateKey.size
}

private fun main(){
    println("2\n${solution(arrayOf(
        arrayOf("100","ryan","music","2"), arrayOf("200","apeach","math","2"),
        arrayOf("300","tube","computer","3"), arrayOf("400","con","computer","4"),
        arrayOf("500","muzi","music","3"), arrayOf("600","apeach","music","2")))}")
}