import java.io.*;
import java.util.*;

public class Solution {

    static final int n = 16;
    static int[][] map = new int[n][n]; //0 길, 1 벽, 2 출발, 3 도착
    static boolean[][] visited = new boolean[n][n];
    static int[] start;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            ans = 0;
            int testCase = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) Arrays.fill(visited[i], false);
            for(int i = 0; i<n; i++){
                String line = br.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = line.charAt(j) - '0';
                    if(map[i][j] == 2){
                        start = new int[] {i, j};
                    }
                }
            }
            Queue<int[]> q = new ArrayDeque<>();
            q.add(start);
            visited[start[0]][start[1]] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int i=0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]){
                        if(map[nx][ny] == 3){
                            ans = 1;
                            break;
                        } else if(map[nx][ny] == 0){
                            q.add(new int[] {nx , ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}