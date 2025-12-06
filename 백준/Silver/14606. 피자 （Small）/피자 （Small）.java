import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<=10; i++){
            int x = i/2;
            int y = i-x;
            dp[i] = x*y + dp[x] + dp[y];
        }
        System.out.print(dp[N]);
    }
}