import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~100,000
    static int[][][] dp;
    final static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[100_001][2][2];
        dp[0][0][0] = 0; dp[0][1][0] = 0; dp[0][0][1] = 0;
        dp[1][0][0] = 1; dp[1][1][0] = 1; dp[1][0][1] = 1;
        dp[2][0][0] = 3; dp[2][1][0] = 2; dp[2][0][1] = 2;
        for(int i=3; i<=N; i++){
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][1][0] + dp[i-1][0][1])%MOD;
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1])%MOD;
            dp[i][0][1] = (dp[i-1][0][0] + dp[i-1][1][0])%MOD;
        }
        int ans = (dp[N][0][0] + dp[N][1][0] + dp[N][0][1])%MOD;
        System.out.print(ans);
    }
}