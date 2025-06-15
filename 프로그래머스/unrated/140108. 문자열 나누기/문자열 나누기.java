class Solution {
    public int solution(String s) {
     int result = 0;
        int diffLen = 0;
        char start = 0;

        for (char c : s.toCharArray()) {
            System.out.println(c);
            if (diffLen == 0) {
                start = c;
                diffLen = 1;
                result++;
            } else {
                diffLen += start == c ? 1 : -1;
            }
        }

        return result;
    }
}