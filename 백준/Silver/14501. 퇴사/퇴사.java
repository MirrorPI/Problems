import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        for(int i=1; i<=N; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());
            int nextDay = day+i;
            if(nextDay > N+1) continue;
            dp[nextDay] = Math.max(dp[nextDay], dp[i] + profit);
        }
        int max = 0;
        for(int i=1; i<=N+1; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}