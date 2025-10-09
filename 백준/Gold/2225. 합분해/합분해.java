import java.io.*;
import java.util.*;

public class Main {

    static int N; //수의 범위(1~200)
    static int K; //더할 숫자의 개수(1~200)
    static int[][] dp; //dp[합][몇개 더했는지]
    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];

//        dp[0][1] = 1; //0
//        dp[0][2] = 1; //0+0
//        dp[0][3] = 1; //0+0+0
//        dp[1][1] = 1; //1
//        dp[1][2] = 2; //0+1, 1+0 -> dp[0][1] + dp[1][1]
//        dp[1][3] = 3; //0+0+1, 0+1+0, 1+0+0 -> dp[0][2] + dp[1][2]
//        dp[2][1] = 1; //2
//        dp[2][2] = 3; //0+2, 1+1, 2+0 -> dp[0][1] + dp[1][1] + dp[2][1] -> dp[1][2] + dp[2][1]

        for(int k=1; k<=K; k++){
            for(int n=0; n<=N; n++){
                if(k == 1 || n == 0) {
                    dp[n][k] = 1;
                } else {
                    dp[n][k] = (dp[n-1][k] + dp[n][k-1]) % MOD;
                }
            }
        }
        System.out.print(dp[N][K]);
    }
}