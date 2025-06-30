class Solution {
    int answer = 0;

    public void targetNumber(int[] numbers, int len, int i, int target, int add) {
        if (i == len && add == target) {
            this.answer++;
            return;
        }
        if (i < len) {
            int value = numbers[i++];
            this.targetNumber(numbers, len, i, target, add + value);
            this.targetNumber(numbers, len, i, target, add - value);
        }

    }

    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        this.targetNumber(numbers, len, 0, target, 0);
        return this.answer;
    }
}