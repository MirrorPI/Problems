class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        
        if(len == 1) return sticker[0];
        
        int firstChoice = calMax(sticker, 0, len-2);
        int firstNotChoice = calMax(sticker, 1, len-1);
            
        return Math.max(firstChoice, firstNotChoice);
    }
    
    
    public int calMax(int[] sticker, int s, int e) {
        int len = e - s + 1;
        if(len == 1) return sticker[s];
            
        int[] dp = new int[sticker.length];
        dp[s] = sticker[s];
        dp[s+1] = Math.max(sticker[s], sticker[s+1]);
        for(int i=s; i<e-1; i++) {
            dp[i+2] = Math.max(dp[i] + sticker[i+2], dp[i+1]);
        }
        
        return dp[e];
     }
}