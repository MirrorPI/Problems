import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][10];

        for (int d = 0; d <= 9; d++) {
            dp[1][d] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int d = 1; d <= 9; d++) {
                dp[i+1][d] = (dp[i+1][d - 1] + dp[i][d]) % 10007;
            }
        }
        int ans = 0;
        for(int i=0; i<10; i++){
            ans += dp[n][i];
        }
        System.out.print(ans%10007);
    }
}