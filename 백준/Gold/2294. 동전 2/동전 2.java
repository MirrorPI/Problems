import java.io.*;
import java.util.*;

public class Main {

    static int n, k; //동전의 개수, 목표 가치
    static int[] dp;
    static Set<Integer> coins = new HashSet<>();
    final static int INF = 11111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            int worth = Integer.parseInt(br.readLine());
            if(worth > k) continue;
            coins.add(worth);
        }
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int coin : coins) {
            for(int v = coin; v<=k; v++){
                dp[v] = Math.min(dp[v], dp[v-coin] + 1);
            }
        }
        System.out.print(dp[k] == INF ? -1 : dp[k]);
    }
}