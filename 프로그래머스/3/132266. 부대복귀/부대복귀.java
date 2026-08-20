import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road: roads) {
            int u = road[0];
            int v = road[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] time = bfs(n, destination, graph);
        int[] ans = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(time[sources[i]] == 0 && sources[i] != destination) time[sources[i]] = -1;
            
            ans[i] = time[sources[i]];
        }
        
        return ans;
    }
    
    public int[] bfs(int n, int s, List<Integer>[] graph) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = true;
        int[] time = new int[n+1];
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int next: graph[curr]) {
                if(visited[next]) continue;
                
                time[next] = time[curr] + 1;
                visited[next] = true;
                q.add(next);
            }
        }
        
        return time;
    }
}