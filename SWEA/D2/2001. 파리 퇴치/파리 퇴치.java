import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int sum = 0;
			int maxSum = 0;
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int j=0; j<N; j++) { //제대로 들어갔는지 확인 --> good!
//				for(int k=0; k<N; k++) {
//					sb.append(map[j][k]).append(" ");
//				}
//				sb.append("\n");
//			}
			
			for(int j=0; j<N-M+1; j++) {
				for(int k=0; k<N-M+1; k++) {
					sum=0;
					for(int q=j; q<j+M; q++) {
						for(int w=k; w<k+M; w++) {
							sum += map[q][w];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			
			sb.append("#").append(i+1).append(" ").append(maxSum);
			System.out.println(sb);
		}
		
		
	}

}
