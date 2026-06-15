class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++) {
            int s = signs[i] ? 1 : -1;
            
            answer += absolutes[i] * s;
        }
        
        return answer;
    }
}