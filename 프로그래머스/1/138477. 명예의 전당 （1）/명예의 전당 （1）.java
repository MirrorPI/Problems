import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> {
            return Integer.compare(s1, s2);
        });
        int[] answer = new int[score.length];
        int day = 0;
        for(int s : score) {
            pq.add(s);
            int worst = 0;
            if(pq.size() > k) {
                worst = pq.poll();
            }
            worst = pq.peek();
            answer[day++] = worst;
        }
        
        
        return answer;
    }
}