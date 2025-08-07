import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int nMax = 9;
        
        Set<Integer>[] dp = new HashSet[nMax];
        for(int i = 0; i < nMax; i++){
            dp[i] = new HashSet<>();
        }
        
        for(int i = 1; i < nMax; i++){
            String repeated = String.valueOf(N).repeat(i);
            Integer num = Integer.parseInt(repeated);
            dp[i].add(num);
            
            for(int j = 1; j < i; j++){
                for(int value : dp[j]){
                    for(int beforeValue : dp[i - j]){
                        dp[i].add(value + beforeValue);
                        dp[i].add(value - beforeValue);
                        dp[i].add(value * beforeValue);
                        if (beforeValue != 0) dp[i].add(value /  beforeValue);
                    }
                }
            }
            if(dp[i].contains(number)) return i;
        }
        
        return -1;
    }
}