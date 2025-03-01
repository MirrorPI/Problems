import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dx = {-1, 1, 0, 0}; //상하좌우 
	static final int[] dy = {0, 0, -1, 1};
	static int N;
	static int[][] map;
	static int[][] dp;
	static int maxMove;
	static int minValue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			maxMove = 0;
			minValue = N*N;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(dp[i][j] == 0) {
						maxMove = Math.max(maxMove, solve(i, j));
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
				
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(dp[i][j] == maxMove) {
						minValue = Math.min(minValue, map[i][j]);
					}
					
				}
			}
			
			sb.append("#").append(tc).append(" ").append(minValue).append(" ").append(maxMove).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	private static int solve(int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];
		
		int move = 1;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == map[x][y]+1) {
				if(dp[nx][ny] != 0) return dp[x][y] = dp[nx][ny]+1;
				move = solve(nx, ny) + 1;
			}
		}
		return dp[x][y] = move;
	}
}