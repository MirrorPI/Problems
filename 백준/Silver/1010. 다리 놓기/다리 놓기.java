import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int n, m;//다리 지을 지점 개수 (0<n<=m<30)
	static int[][] mCn = new int[31][31]; //겹치지 않고 다리를 지을 경우의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i=0; i<=30; i++) {
			mCn[i][0] = 1;
			mCn[i][i] = 1;
		}
		for(int i=1; i<=30; i++) {
			for(int j=1; j<=30; j++) {
				mCn[i][j] = mCn[i-1][j-1] + mCn[i-1][j];
			}
		}
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb.append(mCn[m][n]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
