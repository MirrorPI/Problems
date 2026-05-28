import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((w1, w2) -> {
            return Integer.compare(w2, w1);
        });

        for(int w : works) {
            pq.add(w);
        }
        for(int i=0; i<n; i++) {
            if(pq.isEmpty()) break;
            int w = pq.poll();
            if(w == 0) continue;
            pq.add(w - 1);
        }
        long answer = 0L;
        while(!pq.isEmpty()) {
            int w = pq.poll();
            answer += w*w;
        }
        return answer;
    }
}