import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int n=2; n<=40; n++){
            dp[n][0] = dp[n-1][0] + dp[n-2][0];
            dp[n][1] = dp[n-1][1] + dp[n-2][1];
        }
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.print(sb);
    }
}