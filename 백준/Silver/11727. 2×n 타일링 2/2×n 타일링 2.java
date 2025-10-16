import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~1,000)
    static int[] dp;
    final static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[10001];
        dp[0] = 1;
        dp[1] = 1;
//        dp[2] = dp[1] + dp[0]*2;
//        dp[3] = dp[2] + dp[1]*2;
        for(int i=2; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2)%MOD;
        }
        System.out.print(dp[N]);
    }
}