import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~100
    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[101][10];
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j==0) {
                    dp[i][1] =  (dp[i][1] + dp[i-1][0]) % MOD;
                } else if(j==9) {
                    dp[i][8] =  (dp[i][8] + dp[i-1][9]) % MOD;
                } else {
                    dp[i][j-1] =  (dp[i][j-1] + dp[i-1][j]) % MOD;
                    dp[i][j+1] =  (dp[i][j+1] + dp[i-1][j]) % MOD;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<10; i++){
            ans = (ans + dp[N][i]) % MOD;
        }
        System.out.print(ans);
    }
}