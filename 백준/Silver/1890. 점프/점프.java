import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //(4~100)
    static int[][] map; //(0~9)
    static long[][] dp;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for(int x=0; x<N; x++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int y=0; y<N; y++){
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void solve() {
        dp[0][0] = 1;
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(map[x][y] == 0) continue;

                int nx = x + map[x][y];
                int ny = y + map[x][y];
                if(nx < N) {
                    dp[nx][y] += dp[x][y];
                }
                if(ny < N) {
                    dp[x][ny] += dp[x][y];
                }

            }
        }
        System.out.print(dp[N-1][N-1]);
    }
}