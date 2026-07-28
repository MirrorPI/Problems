import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingQ = new ArrayDeque<>();
        Queue<int[]> bridgeQ = new ArrayDeque<>();
        
        for(int t : truck_weights) {
            waitingQ.add(t);
        }
        
        int time = 0;
        int totalWeight = 0;
        while(!waitingQ.isEmpty() || !bridgeQ.isEmpty()) {
            time++;
            
            if(!bridgeQ.isEmpty()) {
                int[] bridgeTruck = bridgeQ.peek();
                
                if(bridgeTruck[0] + bridge_length == time) {
                    bridgeQ.poll();
                    totalWeight -= bridgeTruck[1];
                    
                }
            }
            
            if(!waitingQ.isEmpty()) {
                int waitingTruck = waitingQ.peek();
                
                if(totalWeight + waitingTruck <= weight) {
                    waitingQ.poll();
                    bridgeQ.add(new int[] {time, waitingTruck});
                    totalWeight += waitingTruck;
                }
            }
        }
        
        return time;
    }
}