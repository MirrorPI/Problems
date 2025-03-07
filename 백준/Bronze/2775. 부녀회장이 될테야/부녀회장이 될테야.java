import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	//a층의 b호 = a-1층, 1호 + 2호 + ... + b호
	static int k, n; //k층 n호에 몇 명이 살고 있는가?
	static int result;
	static int[][] apt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		apt = new int[15][15]; //0층 ~ 14층, 1호 ~ 14호
		for(int i=1; i<=14; i++) {
			apt[0][i] = i;
		}
		apt[1][1] = apt[0][1];
//		apt[1][2] = apt[1][1] + apt[0][2];
//		apt[1][3] = apt[1][2] + apt[0][3];
		for(int i=1; i<=14; i++) {
			for(int j=0; j<=13; j++) {
				apt[i][j+1] = apt[i][j] + apt[i-1][j+1];
			}
		}
 		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(apt[k][n]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
