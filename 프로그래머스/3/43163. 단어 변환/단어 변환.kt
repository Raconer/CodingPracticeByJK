import java.util.Queue
import java.util.LinkedList

class Solution {
     fun solution(begin: String, target: String, words: Array<String>): Int {

     // 찾을 내용이 없을경우
        if( words.indexOf(target) == -1) return 0

        val wordLen = begin.length  // 모든 단어의 길이는 동일하므로 저장

        val tempWords = words.toMutableList()  // words 배열을 수정 가능한 리스트로 복사
        tempWords.add(0, begin)  // begin 단어를 가장 앞에 삽입

        val tempWordLen = tempWords.size  // 총 단어 개수 (begin 포함)

        val convertQueue: Queue<Int> = LinkedList()  // 단어 인덱스를 담을 BFS용 큐
        convertQueue.add(0)  // 시작 단어 begin은 tempWords[0]이므로 인덱스 0 추가

        val convertList = IntArray(tempWordLen)  // 각 인덱스까지 도달하는 데 걸린 단계 수 저장
        convertList[0] = 1  // 시작은 1로 세팅 (실제 변환 횟수는 -1 해야 함)

        val visited = BooleanArray(tempWordLen)  // 방문 여부를 체크할 배열
        visited[0] = true  // 시작 단어는 방문한 것으로 처리

// BFS 시작
        while (convertQueue.isNotEmpty()) {
            val currentWordIndex = convertQueue.poll()  // 현재 단어 인덱스 꺼냄
            val currentWord = tempWords[currentWordIndex]  // 현재 단어 값

            // 전체 단어 리스트 순회 (begin 제외, 인덱스 1부터)
            for (index in 1 until tempWordLen) {
                if (visited[index]) continue  // 이미 방문한 단어는 건너뜀

                val nextWord = tempWords[index]
                var checkCnt = 0  // 현재 단어와 다음 단어의 글자 차이 수

                // 두 단어 간 글자 수 차이 계산
                for (charIndex in 0 until wordLen) {
                    if (currentWord[charIndex] != nextWord[charIndex]) {
                        checkCnt++
                    }
                    if (checkCnt > 1) break  // 한 글자 이상 다르면 변환 불가
                }

                // 한 글자만 다르면 변환 가능
                if (checkCnt == 1) {
                    if (nextWord == target) {
                        return convertList[currentWordIndex]  // target에 도달 → 변환 횟수 반환
                    }

                    visited[index] = true  // ✅ 방문 처리 (기존 코드에서는 currentWordIndex에 잘못 처리됨)
                    convertQueue.add(index)  // 다음 탐색 대상으로 큐에 추가
                    convertList[index] = convertList[currentWordIndex] + 1  // 단계 수 갱신
                }
            }
        }

        return 0  // BFS를 모두 탐색했는데 target에 도달하지 못한 경우
    }
}