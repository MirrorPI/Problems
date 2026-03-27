import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<Integer>[] winWay = new ArrayList[n+1];
        ArrayList<Integer>[] loseWay = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            winWay[i] = new ArrayList<>();
            loseWay[i] = new ArrayList<>();
        }
        for(int[] result : results) {
            int w = result[0];
            int l = result[1];
            winWay[w].add(l);
            loseWay[l].add(w);
        }
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(isRanked(n, i, winWay, loseWay)) answer++;
        }
        return answer;
    }
    public boolean isRanked(int n, int player, ArrayList<Integer>[] win, ArrayList<Integer>[] lose) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        int winCnt = count(q, win,visited, player);
        int loseCnt = count(q, lose, visited, player);
        
        return winCnt + loseCnt == n-1;
    }
    public int count(Queue<Integer> q, ArrayList<Integer>[] result, boolean[] visited, int player) {
        int cnt = 0;
        Arrays.fill(visited, false);
        visited[player] = true;
        q.add(player);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : result[curr]) {
                if(visited[next]) continue;
                
                cnt++;
                visited[next] = true;
                q.add(next);
            }
        }
        return cnt;
    }
}
