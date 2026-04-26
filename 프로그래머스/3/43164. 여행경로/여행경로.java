import java.util.*;

class Solution {
    
    String[][] sortedTickets;
    boolean[] used;
    String[] answer;
    int n;
    
    
    public String[] solution(String[][] tickets) {
        //만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
        //알파벳순 정렬 -> 알파벳순으로 가능여부를 확인
        Arrays.sort(tickets, (t1, t2) -> {
            if(t1[0].equals(t2[0])) {
                return t1[1].compareTo(t2[1]);
            }
            return t1[0].compareTo(t2[1]);
        });
        sortedTickets = tickets;
        n = tickets.length;
        used = new boolean[n];
        
        String[] path = new String[n+1];
        String start = "ICN";
        path[0] = start;
        dfs(start, 0, path);
        
        return answer;
    }
    
    public boolean dfs(String curr, int depth, String[] path) {
        if(depth == n) {
            answer = path;
            return true;
        }
        
        for(int i=0; i<n; i++) {
            if(used[i] || !curr.equals(sortedTickets[i][0])) continue;
               
            used[i] = true;
            path[depth+1] = sortedTickets[i][1];
            
            if(dfs(sortedTickets[i][1], depth+1, path)) {
                return true;
            }
            
            used[i] = false;
        }
        
        return false;
    }
}