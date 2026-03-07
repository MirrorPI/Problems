import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int[] count = new int[n+1];
        count[1] = 1;
        q.add(new int[] {1, 1});
        int max = 0;
        visited[1] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currD = curr[1];
            for(int next : graph[currX]) {
                if(visited[next]) continue;
                
                int dist = currD + 1;
                count[next] = dist;
                max = Math.max(dist, max);
                q.add(new int[] {next, max});
                visited[next] = true;
            }
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(count[i] == max) answer++;
        }
        return answer;
    }
}