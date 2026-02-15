import java.io.*;
import java.util.*;

class Solution {
    
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        map = maps;
        return bfs(n, m);
    }
    public int bfs(int n, int m) {
        int[][] cnt = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        cnt[0][0] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 0 || cnt[nx][ny] != 0) continue;
                
                q.add(new int[] {nx, ny});
                cnt[nx][ny] = cnt[x][y] + 1;
            }
        }
        return cnt[n-1][m-1] == 0 ? -1 : cnt[n-1][m-1];
    }
}