import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length; // prices의 길이
        int[] answer = new int[n]; // 길이가 같은 answer 배열 생성

        for (int i = 0; i < n; i++) {
            int count = 0; // 떨어지지 않은 기간 카운트
            for (int j = i + 1; j < n; j++) {
                count++; // 시간 증가
                if (prices[j] < prices[i]) { // 가격이 떨어지면
                    break; // 루프 종료
                }
            }
            answer[i] = count; // 떨어지지 않은 기간 저장
        }

        return answer; // 결과 반환
    }
}