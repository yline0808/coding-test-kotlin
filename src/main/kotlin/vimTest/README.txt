# 코틀린 cli환경 실행시 명령어
# 코틀린 jar파일로 컴파일 >>> java 로 .jar 결과 출력 >>> 결과물 삭제
kotlinc 이름.kt -include-runtime -d 결과.jar && java -jar 결과.jar && rm 결과.jar