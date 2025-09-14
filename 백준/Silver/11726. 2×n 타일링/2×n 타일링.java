import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    final static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        if(N>1){
            dp[2] = dp[1] + dp[0];
            for(int i=3; i<=N; i++){
                dp[i] = (dp[i-2] + dp[i-1]) % MOD;
            }
        }

        System.out.print(dp[N]);
    }
}