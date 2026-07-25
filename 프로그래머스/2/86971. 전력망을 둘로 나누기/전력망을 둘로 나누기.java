import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: wires) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int ans = 111;
        for(int[] edge: wires) {
            int u = edge[0];
            int v = edge[1];
            
            int cnt = bfs(u, graph, n, u, v);
            ans = Math.min(ans, Math.abs(2 * cnt - n));
        }
        
        return ans;
    }
    
    public int bfs(int start, List<Integer>[] graph, int n, int u, int v) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        int cnt = 1;
        q.add(start);
        visited[start] = true;      

        while(!q.isEmpty()) {
            int curr = q.poll();

            
            for(int next : graph[curr]) {
                if(u == curr && v == next) continue;
                if(v == curr && u == next) continue;
                if(visited[next]) continue;
                
                q.add(next);
                cnt++;

                visited[next] = true;     
            }
        }
        
        return cnt;
    }
}