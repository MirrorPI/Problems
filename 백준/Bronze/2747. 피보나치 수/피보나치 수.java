import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N;
    static long[] dp;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
    }
    public static void solve() {
        for(int i=0; i<N-1; i++){
            dp[i+2] = dp[i+1] + dp[i];
        }
        System.out.print(dp[N]);
    }
}