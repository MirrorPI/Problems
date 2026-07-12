class Solution {

    int k;
    int[][] dungeons;
    int dungeonCount;
    boolean[] visited;
    int ans;

    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        this.dungeonCount = dungeons.length;
        this.visited = new boolean[dungeonCount];

        dfs(k, 0);
        
        return ans;
    }
    
    private void dfs(int currentFatigue, int count) {
        if(currentFatigue < 0) return;
        ans = Math.max(ans, count);

        for(int i=0; i<dungeonCount; i++) {
            if(visited[i]) continue;
            
            if(dungeons[i][0] > currentFatigue) continue;
            
            if(dungeons[i][1] > currentFatigue) continue;
            
            visited[i] = true;
            dfs(currentFatigue - dungeons[i][1], count+1);
            visited[i] = false;
        }
    }
}