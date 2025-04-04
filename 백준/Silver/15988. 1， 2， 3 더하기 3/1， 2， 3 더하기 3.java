import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int maxN = 1_000_001;
	static long[] dp = new long[maxN];
	static final int MOD = 1_000_000_009;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		dp[1] = 1; //1
		dp[2] = 2; //1 1, 2
		dp[3] = 4; //1 1 1, 1 2, 2 1, 3
 		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=4; j<=n; j++) {
				dp[j] = (dp[j-3] + dp[j-2] + dp[j-1])%MOD;
			}
			sb.append(dp[n]).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
		
	}
}
