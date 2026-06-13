import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> {
            if(r1[1] == r2[1]) {
                return Integer.compare(r1[0], r2[0]);
            }
            return Integer.compare(r1[1], r2[1]);
        });
        
        int camera = routes[0][1];
        int cnt = 1;
        for(int[] r : routes) {
            if(r[0] > camera) {
                cnt++;
                camera = r[1];
            }
            
            
         }
        
        return cnt;
    }
}