import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~100,000)
    static int[] arr; //(-1,000~1,000)
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            arr[i] = Math.max(arr[i], arr[i]+arr[i-1]);
            dp[i] = Math.max(dp[i-1] , arr[i]);
        }

        System.out.print(dp[N-1]);
    }
}