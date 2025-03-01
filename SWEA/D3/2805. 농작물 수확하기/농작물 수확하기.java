import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	static int[][] farm;
	static int[] idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			idx = new int[N/2];
			
			for(int j=0; j<N/2; j++) {
				idx[j] = N/2 - j;
			}
			
			for(int j=0; j<N; j++) {
				String str = br.readLine();
				for(int k=0; k<N; k++) {
					farm[j][k] = str.charAt(k)-'0';
				}
			}
			
//			for(int j=0; j<N; j++) { //입력확인
//				for(int k=0; k<N; k++) {
//					System.out.print(farm[j][k] + " ");
//				}
//				System.out.println();
//			}
			
			int sum = 0;
			
			if(N == 1) {
				sum = farm[0][0];
			} else {
				for(int j=0; j<N/2; j++) {
					for(int k=0; k<N - 2*idx[j]; k++) {
						sum += farm[j][idx[j]+k];
					}
				}
				for(int j=0; j<N; j++) {
					sum += farm[N/2][j];
				}
				for(int j=0; j<N/2; j++) {
					for(int k=0; k<N - 2*idx[N/2-1-j]; k++) {
						sum += farm[N/2+1+j][idx[N/2-1-j]+k];
					}
				}
				
			}
			sb.append("#").append(i+1).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
	}
}
