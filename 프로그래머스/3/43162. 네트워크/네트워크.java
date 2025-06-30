class Solution {
    int answer = 0;

       public void netWork(boolean[] checked, int[][] computers, int i, int len) {
        for (int j = 0; j < len; j++) {
            if (i != j && computers[i][j] == 1 && !checked[j]) {
                checked[j] = true;
                this.netWork(checked, computers, j, len);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        if (n == 1) {
            return 1;
        }

        int answer = 0;
        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                this.netWork(checked, computers, i, n);
                answer++;
            }
        }
        return answer;
    }

}