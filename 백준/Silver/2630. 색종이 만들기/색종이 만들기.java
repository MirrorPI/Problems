import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cntW;
	static int cntB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 2 4 8 16 32 64 128
		int[][] paper = new int[N+1][N+1]; // ~2^14
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divideAndCheck(paper, N, 1, 1);
		sb.append(cntW).append("\n").append(cntB);
		System.out.print(sb);
	}
	
	public static void divideAndCheck(int[][] paper, int N, int x, int y) {
		if(N < 1) return;
		int sum = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum += paper[x+i-1][y+j-1];
			}
		}
		if(sum==0) {
			cntW++;
			return;
		} else if(sum == N*N) {
			cntB++;
			return;
		}
		
		divideAndCheck(paper, N/2, x, y);  
		divideAndCheck(paper, N/2, x, y+N/2);
		divideAndCheck(paper, N/2, x+N/2, y);
		divideAndCheck(paper, N/2, x+N/2, y+N/2);
		
		
		return;
	}
}
