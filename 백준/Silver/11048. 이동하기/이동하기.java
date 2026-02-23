import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N, M; //(1~1,000)
    static int[][] map; //(0~100)
    static int[][] dp;
    static boolean[][] visited;
    final static int[] dx = {1, 0, 1};
    final static int[] dy = {0, 1, 1};

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int x=1; x<=N; x++){
            st = new StringTokenizer(br.readLine());
            for(int y=1; y<=M; y++){
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void solve() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});
        dp[1][1] = map[1][1];
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if(visited[x][y]) continue;
            visited[x][y] = true;
            for(int d=0; d<3; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx>N || ny>M) continue;

                dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + map[nx][ny]);
                q.add(new int[] {nx, ny});

            }
        }
        System.out.print(dp[N][M]);
    }
}