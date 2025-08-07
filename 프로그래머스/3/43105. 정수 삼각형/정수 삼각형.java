class Solution {
    public int solution(int[][] triangle) {
        int row = triangle.length;

        int[][] dp = new int[row][];
        for (int i = 0; i < row; i++) {
            dp[i] = triangle[i].clone();
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] += Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}