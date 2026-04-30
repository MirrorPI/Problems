import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] have = new int[n+1];
        Arrays.fill(have, 1);
        for(int i=0; i<lost.length ; i++){
            have[lost[i]]--;
        }
        for(int i=0; i<reserve.length ; i++){
            have[reserve[i]]++;
        }
        for(int i=1; i<=n; i++){
            if(i == 1 && have[1] == 2 && have[2] == 0) {
                have[1]--;
                have[2]++;
            }
            if(i < n && have[i] == 2) {
                if(have[i-1] == 0) {
                    have[i]--;
                    have[i-1]++;
                } else if(have[i+1] == 0) {
                    have[i]--;
                    have[i+1]++;
                }
            }
            if(i == n && have[n] == 2 && have[n-1] == 0) {
                have[n]--;
                have[n-1]++;
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(have[i] > 0) answer++;
        }
        return answer;
    }
}