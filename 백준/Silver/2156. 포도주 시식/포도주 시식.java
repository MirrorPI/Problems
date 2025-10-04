import java.io.*;
import java.util.*;

public class Main {

    static int n; //포도주 잔의 개수(1~10,000)
    static int[] wineglass; //(0~1,000)
    static int[][] dp; //dp[와인잔의 순서][지금까지 연속 몇잔을 마셨는 가]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        wineglass = new int[n];
        dp = new int[n][3];
        for(int i=0; i<n; i++){
            wineglass[i] = Integer.parseInt(br.readLine());
        }
        dp[0][0] = 0;
        dp[0][1] = wineglass[0];
        dp[0][2] = 0;

        for(int i=0; i<n-1; i++){
            dp[i+1][0] = Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]);
            dp[i+1][1] = dp[i][0] + wineglass[i+1];
            dp[i+1][2] = dp[i][1] + wineglass[i+1];
        }

        int max = Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.print(max);
    }
}