class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(s < n) return answer;
       
        
        answer = new int[n];
        int a = s/n;
        int r = s%n;
        for(int i=0; i<n; i++) {
            answer[i] = a;
        }
        for(int i=0; i<r; i++) {
            answer[n-1-i] += 1;
        }

        return answer;
    }
}