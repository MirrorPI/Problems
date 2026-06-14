import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int totalW = 2*w+1;
        int answer = 0;
        int bs = 1;
        int b = 0;
        for(int s : stations) {
            b = s - w - bs;
            bs = s + w + 1;
            if(b <= 0) continue;
                
            answer += b%totalW==0 ? b/totalW : b/totalW+1;
        }
        b = n-bs+1;
        if(b <=0 ) return answer;
        
        answer += b%totalW==0 ? b/totalW : b/totalW+1;

        return answer;
    }
}