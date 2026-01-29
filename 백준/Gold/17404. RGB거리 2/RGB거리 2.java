import java.io.*;
import java.util.*;

public class Main {

    static int N; //집의 수(2~1,000)
    static int[][] cost; //i번째 집의 색칠 비용(1~1,000), 0 r, 1 g, 2 b
    static int[][][] dp;
    final static int R = 0;
    final static int G = 1;
    final static int B = 2;
    final static int INF = 999_999_999;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3][3]; //i번째 집 j색으로 시작 지금 k색 칠함
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                Arrays.fill(dp[i][j], INF);
            }
        }

        cost = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++){
                cost[i][c] = Integer.parseInt(st.nextToken());
            }
            for(int sc=0; sc<3; sc++){
                dp[0][sc][sc] = cost[0][sc];
            }
        }
        dp[1][R][G] = dp[0][R][R] + cost[1][G];
        dp[1][R][B] = dp[0][R][R] + cost[1][B];
        dp[1][G][R] = dp[0][G][G] + cost[1][R];
        dp[1][G][B] = dp[0][G][G] + cost[1][B];
        dp[1][B][G] = dp[0][B][B] + cost[1][G];
        dp[1][B][R] = dp[0][B][B] + cost[1][R];
    }
    public static void solve() {
        for(int i=2; i<N-1; i++){
            dp[i][R][G] = Math.min(dp[i-1][R][R], dp[i-1][R][B]) + cost[i][G];
            dp[i][R][R] = Math.min(dp[i-1][R][G], dp[i-1][R][B]) + cost[i][R];
            dp[i][R][B] = Math.min(dp[i-1][R][R], dp[i-1][R][G]) + cost[i][B];

            dp[i][G][G] = Math.min(dp[i-1][G][R], dp[i-1][G][B]) + cost[i][G];
            dp[i][G][R] = Math.min(dp[i-1][G][G], dp[i-1][G][B]) + cost[i][R];
            dp[i][G][B] = Math.min(dp[i-1][G][R], dp[i-1][G][G]) + cost[i][B];

            dp[i][B][G] = Math.min(dp[i-1][B][R], dp[i-1][B][B]) + cost[i][G];
            dp[i][B][R] = Math.min(dp[i-1][B][G], dp[i-1][B][B]) + cost[i][R];
            dp[i][B][B] = Math.min(dp[i-1][B][R], dp[i-1][B][G]) + cost[i][B];
        }
        dp[N-1][R][G] = Math.min(dp[N-2][R][R], dp[N-2][R][B]) + cost[N-1][G];
        dp[N-1][R][B] = Math.min(dp[N-2][R][R], dp[N-2][R][G]) + cost[N-1][B];

        dp[N-1][G][R] = Math.min(dp[N-2][G][G], dp[N-2][G][B]) + cost[N-1][R];
        dp[N-1][G][B] = Math.min(dp[N-2][G][R], dp[N-2][G][G]) + cost[N-1][B];

        dp[N-1][B][G] = Math.min(dp[N-2][B][R], dp[N-2][B][B]) + cost[N-1][G];
        dp[N-1][B][R] = Math.min(dp[N-2][B][G], dp[N-2][B][B]) + cost[N-1][R];
        int min = 999_999_999;
        for(int sc=0; sc<3; sc++){
            for(int c=0; c<3; c++){
                if(dp[N-1][sc][c] == INF) continue;

                min = Math.min(dp[N-1][sc][c], min);
            }
        }
        System.out.print(min);
    }

}