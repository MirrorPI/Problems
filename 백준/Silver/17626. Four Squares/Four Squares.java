import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~50,000
    static ArrayList<Integer> square;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.print(dp[N]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        for(int i=1; i*i<=N; i++){
            dp[i*i] = 1;
        }
    }
    public static void solve() {
        for(int i=1; i<=N; i++){
            if(dp[i] == 1) continue;

            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
    }
}