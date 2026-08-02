class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=4; i<=n; i++) {
            int mesureCnt = 0;
            for(int j=1; j*j<=i; j++) {
                if(j*j == i) {
                    mesureCnt += 1;
                } else if(i%j == 0) {
                    mesureCnt  += 2;
                }
            }
            if(mesureCnt >= 3) answer++;
        }
        
        return answer;
    }
}