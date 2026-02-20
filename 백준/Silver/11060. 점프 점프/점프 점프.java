import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //미로의 길이 (1~1,000)
    static int[] A; //미로에 적힌 정수(0~100)
    static int[] dp;
    static int INF = 1111;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    public static void solve() {
        dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i=0; i<N-1; i++){
            int num = A[i];
            while(num-- > 0){
                int next = i+num+1;
                if(next >= N) continue;

                dp[next] = Math.min(dp[i] + 1, dp[next]);
                //System.out.println(dp[next]);
            }
        }
        System.out.print(dp[N-1] == INF ? -1 : dp[N-1]);
    }
}