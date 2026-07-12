class Solution {
    public int[] solution(int[] arr) {
        int arrLen = arr.length;
        int[] answer = new int[arrLen];
        for(int i=0; i<arrLen; i++) {
            int n = arr[i];
            if(n >= 50 && n%2 == 0) {
                n /= 2;
            } else if(n < 50 && n%2 == 1) {
                n *= 2;
            }
            answer[i] = n;
        }
        return answer;
    }
}