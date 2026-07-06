import java.util.*;

class Solution {
    
    public class Process {
        int priority;
        int firstLocation;
        
        Process(int priority, int firstLocation) {
            this.priority = priority;
            this.firstLocation = firstLocation;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        
        int len = priorities.length;
        int[] prioritiesCount = new int[10];

        for(int i=0; i<len; i++) {
            int p = priorities[i];
            q.add(new Process(p, i));
            prioritiesCount[p] += 1;
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            Process process = q.poll();
            
            if(!isHighestPriority(process.priority, prioritiesCount)) {
                q.add(process);
            } else {
                answer += 1;
                prioritiesCount[process.priority] -= 1;
                
                if(process.firstLocation == location) return answer;
            }
            
        }

        return answer;
    }
    public boolean isHighestPriority(int p, int[] prioritiesCount) {
        for(int s = p+1; s<=9; s++) {
            if(prioritiesCount[s] > 0) return false;
        }
        
        return true;
    }
}