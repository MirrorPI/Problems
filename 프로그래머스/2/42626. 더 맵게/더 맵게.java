import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>((s1, s2) -> {
            return Long.compare(s1, s2);
        });
        for(long s : scoville) {
            pq.add(s);
        }
        int count = 0;
        while(pq.size() >= 2){
            long first = pq.poll();
            if(first >= K) break;
             
            long second = pq.poll();
            long mix = first + second*2;
            pq.add(mix);
            count++;
        }
        
        return pq.poll() < K ? -1 : count;
    }
}