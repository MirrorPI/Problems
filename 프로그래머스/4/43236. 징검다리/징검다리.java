import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int start = 0;
        int end = distance;
        int answer = 0;
        while(start <= end) {
            int mid = (start + end)/2;
            
            if(isMidMin(rocks, mid, n, distance)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
    public boolean isMidMin(int[] rocks, int mid, int n, int distance) {
        int curr = 0;
        int removed = 0;
        int rocksLength = rocks.length;
        for(int rock : rocks) {
            if(rock - curr < mid) {
                removed++;
            } else {
                curr = rock;
            }
        }
        if(distance - curr < mid) {
                removed++;
        }
        
        return removed <= n;
    }
}