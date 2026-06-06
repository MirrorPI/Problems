class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int size = s.length();
        int[] answer = new int[size];
        int c = 0;
        for(int i=size-1; i>=0; i--) {
            answer[c++] = s.charAt(i) - '0';
        }
        return answer;
    }
}