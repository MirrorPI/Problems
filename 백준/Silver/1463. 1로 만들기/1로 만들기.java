import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int max =  1_000_001;
    static int[] dp = new int[max];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<max; i++){
            if(i % 3 == 0 && i % 2 != 0){
                dp[i] = Math.min(1+dp[i/3], 1+dp[i-1]);
            } else if (i % 3 != 0 && i % 2 == 0) {
                dp[i] = Math.min(1+dp[i/2], 1+dp[i-1]);
            } else if (i % 3 != 0 && i % 2 != 0){
                dp[i] = 1 + dp[i-1];
            } else {
                dp[i] = Math.min(Math.min(1+dp[i/3], 1+dp[i/2]), 1+dp[i-1]);
            }
        }
        System.out.print(dp[N]);
        br.close();
    }
}