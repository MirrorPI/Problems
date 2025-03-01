import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int B;
	static int[] h;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 직원의 수
			B = Integer.parseInt(st.nextToken()); // 목표 선반의 높이
			h = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
//			for(int i=0; i<N; i++) {
//				System.out.print(h[i] + " ");
//			}
			result = 200001; 
			solve(-1, 0);
			sb.append("#").append(tc).append(" ").append(result - B).append("\n");
		}
		System.out.print(sb);
	}
	private static void solve(int  here, int sum) {
		if(sum >= B) result = Math.min(result, sum); 
		
		for(int next = here+1; next<N; next++) {
			solve(next, sum + h[next]);
		}
	}
}