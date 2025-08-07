class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        // 갈수 없는 곳 체크
        boolean[][] isPuddle = new boolean[n][m];

        for(int[] puddle : puddles){
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }
       
        int[][] map = new int[n][m];
        map[0][0] = 1;
        
        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(isPuddle[y][x]) {
                    map[y][x] = 0;    
                    continue;   
                }
                
                if(y > 0) map[y][x] = (map[y][x] + map[y - 1][x]) % MOD;
                if(x > 0) map[y][x] = (map[y][x] + map[y][x - 1]) % MOD;  
            }
        }
        
  
        
        return map[n - 1][m -1];
    }
    
}