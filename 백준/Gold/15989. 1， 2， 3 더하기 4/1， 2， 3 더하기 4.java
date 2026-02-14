import java.io.*;
import java.util.*;

public class Main {

    static int n; //(1~10,000)
    static long[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        dpSet();
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder(T * 20);
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(br.readLine());
            long ans = dp[1][n] + dp[2][n] + dp[3][n];
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    public static void dpSet() throws IOException {
        dp = new long[4][10001]; //순서가 상관없다면 비내림차순인 상태만 세도 됨 -> [마지막 숫자][지금까지 합] -> 마지막 숫자가 3이면 3밖에 못오고 2이면 2, 3만 오고 1이면 1, 2, 3 다오고
        dp[0][0] = 1;

        dp[1][1] = 1; //1 dp[0][0];

        dp[1][2] = 1; //1+1 dp[1][1] + dp[0][1]
        dp[2][2] = 1; //2 dp[0][0];

        dp[1][3] = 1; //1+1+1 dp[1][2]
        dp[2][3] = 1; //1+2 dp[1][1] dp[2][1]
        dp[3][3] = 1; //3
        for(int i=4; i<=10000; i++){
            dp[1][i] = dp[1][i-1]; //1로 끝나는 i를 만들려면 1로 끝난 i-1 에서 +1을 한 경우
            dp[2][i] = dp[1][i-2] + dp[2][i-2]; //2로 끝나는 i를 만들려면 1로 끝난 i-2 또는 2로 끝난 i-2
            dp[3][i] = dp[1][i-3] + dp[2][i-3] + dp[3][i-3];
        }
    }
}