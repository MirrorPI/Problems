import java.io.*;

public class Main {

    static int tc;
    static int n;
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = dp[1] + 1;
        dp[3] = dp[1] + dp[2] + 1;
        for(int i=4; i<=11; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for(int t=1; t<=tc; t++){
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}